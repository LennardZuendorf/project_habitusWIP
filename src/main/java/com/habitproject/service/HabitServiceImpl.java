package com.habitproject.service;

import com.habitproject.persistence.habit.HabitEntity;
import com.habitproject.persistence.habit.HabitRepository;
import com.habitproject.web.EntityStatusReturns.HabitListStatusReturn;
import com.habitproject.web.EntityStatusReturns.HabitStatusReturn;
import com.habitproject.web.habit.HabitRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class HabitServiceImpl implements HabitService{

    private final HabitRepository habitRepository;
    public HabitServiceImpl(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    //services for habit API endpoints
    /**
     * saving a new habit to database
     * @param requestBody - all of HabitEntity params
     * @return newly created habit
     */
    @Override
    public HabitStatusReturn postHabit(HabitRequestModel requestBody) {
        HabitEntity newHabit = new HabitEntity(requestBody.getTag(), requestBody.getFrequency(), requestBody.getQuantity(), requestBody.getUid());
        habitRepository.saveAndFlush(newHabit);
        return new HabitStatusReturn(newHabit, HttpStatus.CREATED);
    }

    /**
     * getting one HabitEntity by id
     *
     * @param hid - the habit id to select
     * @return selected HabitEntity
     */
    @Override
    public HabitStatusReturn getHabit(Long hid) {
        if (habitRepository.existsById(hid))return new HabitStatusReturn(habitRepository.findFirstByHid(hid), HttpStatus.OK);
        else return new HabitStatusReturn(null, HttpStatus.NO_CONTENT);
    }

    /**
     * getting a list of all habits by UserID
     *
     * @param uid - the user ID to be selected by
     * @return list of HabitEntities
     */
    @Override
    public HabitListStatusReturn getAllHabit(Long uid) {
        if (habitRepository.existsByUid(uid)) return new HabitListStatusReturn(habitRepository.findAllByUid(uid), HttpStatus.OK);
        else return new HabitListStatusReturn(null, HttpStatus.NO_CONTENT);
    }

    /**
     * updating a HabitEntity in the database
     * @param hid          - id of the habit to update
     * @param requestBody - all of HabitEntity params
     * @return updated habit
     */
    @Override
    public HttpStatus putHabit(Long hid, HabitRequestModel requestBody) {
        if(habitRepository.existsById(hid)){
            var habitEntry = habitRepository.findFirstByHid(hid);
            habitEntry.setTag(requestBody.getTag());
            habitEntry.setFrequency(requestBody.getFrequency());
            habitEntry.setQuantity(requestBody.getQuantity());
            habitRepository.saveAndFlush(habitEntry);
            return HttpStatus.OK;
        }else return HttpStatus.NO_CONTENT;
    }

    /**
     * API call for deleting a habit (HabitEntity)
     * @param hid - id of the habit that should be deleted
     * @return deleted habit
     */
    @Override
    public HttpStatus deleteHabit(Long hid) {
        if (habitRepository.existsById(hid)) {
            habitRepository.delete(habitRepository.getOne(hid));
            habitRepository.flush();
            return HttpStatus.OK;
        } else return HttpStatus.NO_CONTENT;
    }

}
