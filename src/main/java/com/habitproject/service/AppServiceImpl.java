package com.habitproject.service;

import com.habitproject.persistence.HabitEntity;
import com.habitproject.persistence.HabitRepository;
import com.habitproject.persistence.UserAccountEntity;
import com.habitproject.persistence.UserRepository;
import com.habitproject.web.api.HabitRequestModel;
import com.habitproject.web.api.UserRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AppService is the class implementing the HabitApp's backend business logic, right now only for HabitEntities
 */

@Service
public class AppServiceImpl implements AppService {

    private final HabitRepository habitRepository;
    private final UserRepository userRepository;
    public AppServiceImpl(HabitRepository repository, UserRepository userRepository) {
        this.habitRepository = repository;
        this.userRepository = userRepository;
    }

    //services for habit API endpoints
    /**
     * saving a new habit to database
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
            return HttpStatus.ACCEPTED;
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

    //services for user API endpoints
    /**
     * saving a new user (UserAccountEntity) to database
     * @param requestBody - all UserAccountEntity params
     * @return https Status code
     */
    @Override
    public HttpStatus postUser(UserRequestModel requestBody) {
        UserAccountEntity newUser = new UserAccountEntity(requestBody.getUsername(), requestBody.getEmail());
        userRepository.saveAndFlush(newUser);
        return HttpStatus.CREATED;
    }

    /**
     * updating a HabitEntity in the database
     * @param uid - id of the user to update
     * @param requestBody - all UserAccountEntity params
     * @return HttpStatus code
     */
    @Override
    public HttpStatus putUser(Long uid, UserRequestModel requestBody) {
        if(userRepository.existsById(uid)){
            UserAccountEntity userEntry = userRepository.findFirstByUid(uid);
            userEntry.setUsername(requestBody.getUsername());
            userEntry.setEmail(requestBody.getEmail());
            userRepository.saveAndFlush(userEntry);
            return HttpStatus.ACCEPTED;
        }else return HttpStatus.NO_CONTENT;
    }

    /**
     * API call for deleting a habit (HabitEntity)
     * @param uid - id of the user to delete
     * @return HttpStatus code
     */
    @Override
    public HttpStatus deleteUser(Long uid) {
        if (userRepository.existsById(uid)) {
            userRepository.delete(userRepository.getOne(uid));
            userRepository.flush();
            return HttpStatus.OK;
        } else return HttpStatus.NO_CONTENT;
    }
}
