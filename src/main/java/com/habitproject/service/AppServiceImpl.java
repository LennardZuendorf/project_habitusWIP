package com.habitproject.service;

import com.habitproject.persistence.HabitEntity;
import com.habitproject.persistence.HabitRepository;
import com.habitproject.web.api.HabitRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AppService is the class implementing the HabitApp's backend business logic, right now only for HabitEntities
 */

@Service
public class AppServiceImpl implements AppService {

    private final HabitRepository habitRepository;
    public AppServiceImpl(HabitRepository repository) {
        this.habitRepository = repository;
    }

    //Services for habit endpoints
    /**
     * saving a new habit to database
     *
     * @param requestBody - all of HabitEntity params
     * @return newly created habit
     */
    @Override
    public HabitEntity postHabit(HabitRequestModel requestBody) {
        HabitEntity newHabit = new HabitEntity(requestBody.getTag(), requestBody.getFrequency(), requestBody.getQuantity(), requestBody.getUid());
        habitRepository.saveAndFlush(newHabit);
        return newHabit;
    }

    /**
     * getting one HabitEntity by id
     *
     * @param hid - the habit id to select
     * @return selected HabitEntity
     */
    @Override
    public HabitEntity getHabit(Long hid) {
        return habitRepository.findFirstByHid(hid);
    }

    /**
     * getting a list of all habits by UserID
     *
     * @param uid - the user ID to be selected by
     * @return list of HabitEntities
     */
    @Override
    public List<HabitEntity> getAllHabit(Long uid) {
        return habitRepository.findAllByUid(uid);
    }

    /**
     * updating a HabitEntity in the database
     *
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
            habitRepository.save(habitEntry);
            return HttpStatus.ACCEPTED;
        }else return HttpStatus.NO_CONTENT;
    }

    /**
     * API call for deleting a habit (HabitEntity)
     *
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
