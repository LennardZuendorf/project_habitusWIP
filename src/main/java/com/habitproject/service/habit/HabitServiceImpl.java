package com.habitproject.service.habit;

import com.habitproject.persistence.habit.HabitEntity;
import com.habitproject.persistence.habit.HabitRepository;
import com.habitproject.web.habit.HabitListStatusReturn;
import com.habitproject.web.habit.HabitStatusReturn;
import com.habitproject.web.habit.HabitRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class HabitServiceImpl implements HabitService{

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
        HabitEntity newHabit = new HabitEntity(requestBody.getTag(), requestBody.getFrequency(), requestBody.getQuantity(), requestBody.getUid());
        repository.saveAndFlush(newHabit);
        return new HabitStatusReturn(newHabit, HttpStatus.CREATED);
    }

    /**
     * getting one HabitEntity by id
     * @param hid - the habit id to select
     * @return HabitStatusReturn - combination of new Entity and status code
     */
    @Override
    public HabitStatusReturn getHabit(Long hid) {
        if (repository.existsById(hid))return new HabitStatusReturn(repository.findFirstByHid(hid), HttpStatus.OK);
        else return new HabitStatusReturn(null, HttpStatus.NO_CONTENT);
    }

    /**
     * getting a list of all habits by UserID
     * @param uid - the user ID to be selected by
     * @return HabitListStatusReturn - combination of new List with Entities and status code
     */
    @Override
    public HabitListStatusReturn getAllHabit(Long uid) {
        if (repository.existsByUid(uid)) return new HabitListStatusReturn(repository.findAllByUid(uid), HttpStatus.OK);
        else return new HabitListStatusReturn(null, HttpStatus.NO_CONTENT);
    }

    /**
     * updating a HabitEntity in the database
     * @param hid          - id of the habit to update
     * @param requestBody - all of HabitEntity params
     * @return http status code
     */
    @Override
    public HttpStatus putHabit(Long hid, HabitRequestModel requestBody) {
        if(repository.existsById(hid)){
            var habitEntry = repository.findFirstByHid(hid);
            habitEntry.setTag(requestBody.getTag());
            habitEntry.setFrequency(requestBody.getFrequency());
            habitEntry.setQuantity(requestBody.getQuantity());
            repository.saveAndFlush(habitEntry);
            return HttpStatus.OK;
        }else return HttpStatus.NO_CONTENT;
    }

    /**
     * API call for deleting a habit (HabitEntity)
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

}
