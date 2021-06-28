package com.habitproject.service.habit;

import com.habitproject.persistence.habit.HabitEntity;
import com.habitproject.persistence.habit.HabitFrequency;
import com.habitproject.persistence.habit.HabitRepository;
import com.habitproject.web.habit.HabitListStatusReturn;
import com.habitproject.web.habit.HabitRequestModel;
import com.habitproject.web.habit.HabitStatusReturn;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HabitServiceImpl implements HabitService{

    LocalDateTime placeholderDate = LocalDateTime.of(1999, 9, 9, 9, 9);

    private final HabitRepository repository;
    public HabitServiceImpl(HabitRepository repository) {
        this.repository = repository;
    }

    //services for habit API endpoints
    /**
     * saving a new habit to database
     * @param requestBody - all of HabitEntity params
     * @return HabitStatusReturn - combination of new Entity and status code
     */
    @Override
    public HabitStatusReturn postHabit(HabitRequestModel requestBody) {
        HabitEntity newHabit = new HabitEntity(requestBody.getUid(), requestBody.getTag(), requestBody.getFrequency(), requestBody.getQuantity(), placeholderDate ,requestBody.isDone(), requestBody.getDoneAmount());
        repository.saveAndFlush(newHabit);
        return new HabitStatusReturn(newHabit, HttpStatus.CREATED);
    }

    /**
     * getting a list of all habits by UserID
     * @param uid - the user ID to be selected by
     * @return HabitListStatusReturn - combination of new List with Entities and status code
     */
    @Override
    public HabitListStatusReturn getHabits(String uid) {
        if (repository.existsByUid(uid)) {
            updateHabitsStatus(uid);
            return new HabitListStatusReturn(repository.findAllByUid(uid), HttpStatus.OK);
        } else return new HabitListStatusReturn(null, HttpStatus.NO_CONTENT);
    }

    /**
     * updating a HabitEntity in the database
     * @param hid - id of the habit to update
     * @param requestBody - all of HabitEntity params
     * @return http status code
     */
    @Override
    public HttpStatus putHabit(Long hid, HabitRequestModel requestBody) {
        if(repository.existsById(hid)){
            updateHabit(hid, requestBody.getTag(), requestBody.getFrequency(), requestBody.getQuantity(),requestBody.isDone(), requestBody.getDoneAmount(), placeholderDate);
            return HttpStatus.OK;
        }else return HttpStatus.NO_CONTENT;
    }

    /**
     * delete a habit (HabitEntity)
     * @param hid - id of the habit that should be deleted
     * @return http status code
     */
    @Override
    public HttpStatus deleteHabit(Long hid) {
        if (repository.existsById(hid)) {
            repository.delete(repository.getOne(hid));
            repository.flush();
            return HttpStatus.OK;
        } else return HttpStatus.NO_CONTENT;
    }

    /**
     * deleting all habit (HabitEntity)
     * @param uid - id of the habit that should be deleted
     * @return http status code
     */
    @Override
    public HttpStatus deleteAllHabits(String uid) {
        if (!repository.findAllByUid(uid).isEmpty()){
            repository.deleteInBatch(repository.findAllByUid(uid));
            return HttpStatus.OK;
        } else return HttpStatus.NO_CONTENT;
    }


    /**
     * updating all habits
     * @param uid - id of the user whos habits should be updated
     * @return http status code
     */
    @Override
    public void updateHabitsStatus(String uid) {
        List<HabitEntity> HabitsList = repository.findAllByUid(uid);

        for(HabitEntity habit : HabitsList) {

            if (habit.getDoneAmount()==habit.getQuantity()) {
                updateHabit(habit.getHid(), habit.getTag(), habit.getFrequency(), habit.getQuantity(), true, habit.getDoneAmount() ,LocalDateTime.now());
            }

            switch (habit.getFrequency().toString()) {
                case "DAILY":
                    if (habit.getLastCheck().plusDays(1).isAfter(LocalDateTime.now())) {
                        updateHabit(habit.getHid(), habit.getTag(), habit.getFrequency(), habit.getQuantity(), false, 0, placeholderDate);
                    }
                    break;
                case "WEEKLY":
                    if (habit.getLastCheck().plusWeeks(1).isAfter(LocalDateTime.now())) {
                        updateHabit(habit.getHid(), habit.getTag(), habit.getFrequency(), habit.getQuantity(), false, 0, placeholderDate);
                    }
                    break;
                case "BIWEEKLY":
                    if (habit.getLastCheck().plusDays(14).isAfter(LocalDateTime.now())) {
                        updateHabit(habit.getHid(), habit.getTag(), habit.getFrequency(), habit.getQuantity(), false, 0, placeholderDate);
                    }
                    break;
                case "TRIWEEKLY":
                    if (habit.getLastCheck().plusWeeks(3).isAfter(LocalDateTime.now())) {
                        updateHabit(habit.getHid(), habit.getTag(), habit.getFrequency(), habit.getQuantity(), false, 0, placeholderDate);
                    }
                    break;
                case "MONTHLY":
                    if (habit.getLastCheck().plusMonths(1).isAfter(LocalDateTime.now())) {
                        updateHabit(habit.getHid(), habit.getTag(), habit.getFrequency(), habit.getQuantity(), false, 0, placeholderDate);
                    }
                    break;
                default:
                    break;

            }
        }
    }

    public void updateHabit (Long hid, String tag, HabitFrequency frequency, Integer quantity, boolean done, Integer doneAmount, LocalDateTime lastCheck){
        var habitEntry = repository.findFirstByHid(hid);

        if(lastCheck.equals(placeholderDate)){
            if(!done)lastCheck = habitEntry.getLastCheck();
        }

        habitEntry.setTag(tag);
        habitEntry.setFrequency(frequency);
        habitEntry.setQuantity(quantity);
        habitEntry.setDone(done);
        habitEntry.setDoneAmount(doneAmount);
        habitEntry.setLastCheck(lastCheck);
        repository.saveAndFlush(habitEntry);

    }
}

