package com.habitproject.service;

import com.habitproject.persistence.goal.GoalEntity;
import com.habitproject.persistence.goal.GoalRepository;
import com.habitproject.persistence.habit.HabitEntity;
import com.habitproject.persistence.habit.HabitRepository;
import com.habitproject.persistence.user.UserAccountEntity;
import com.habitproject.persistence.user.UserRepository;
import com.habitproject.web.EntityStatusReturns.HabitListStatusReturn;
import com.habitproject.web.EntityStatusReturns.HabitStatusReturn;
import com.habitproject.web.goal.GoalRequestModel;
import com.habitproject.web.habit.HabitRequestModel;
import com.habitproject.web.user.UserRequestModel;
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
    private final GoalRepository goalRepository;
    public AppServiceImpl(HabitRepository repository, UserRepository userRepository, GoalRepository goalRepository) {
        this.habitRepository = repository;
        this.userRepository = userRepository;
        this.goalRepository = goalRepository;
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

    //services for goal API endpoints
    /**
     * saving a new goal to database
     * @param requestBody - all of GoalEntity params
     * @return http status code
     */
    @Override
    public HttpStatus postGoal(GoalRequestModel requestBody) {
        GoalEntity newGoal = new GoalEntity(requestBody.getTag(), requestBody.getMeasure(), requestBody.getCurrentAmount(), requestBody.getTotalAmount(), requestBody.getUid());
        goalRepository.saveAndFlush(newGoal);
        return HttpStatus.CREATED;
    }

    /**
     * getting one GoalEntity by id
     * @param gid - the goal id to select by
     * @return selected GoalEntity
     */
    @Override
    public GoalEntity getGoal(Long gid) {
        return goalRepository.findFirstByGid(gid);
    }

    /**
     * getting a list of all goals by UserID
     * @param uid - the user ID to be selected by
     * @return list of GoalEntities
     */
    @Override
    public List<GoalEntity> getAllGoal(Long uid) {
        return goalRepository.findAllByUid(uid);
    }

    /**
     * updating a HabitEntity in the database
     * @param gid          - id of the habit to update
     * @param requestBody - all of HabitEntity params
     * @return Http status code
     */
    @Override
    public HttpStatus putGoal(Long gid, GoalRequestModel requestBody) {
        if(goalRepository.existsById(gid)){
            GoalEntity goalEntity = goalRepository.findFirstByGid(gid);
            goalEntity.setTag(requestBody.getTag());
            goalEntity.setMeasure(requestBody.getMeasure());
            goalEntity.setCurrentAmount(requestBody.getCurrentAmount());
            goalEntity.setTotalAmount(requestBody.getTotalAmount());
            goalRepository.saveAndFlush(goalEntity);
            return HttpStatus.OK;
        }else return HttpStatus.NO_CONTENT;
    }

    /**
     * API call for deleting a goal (GoalEntity)
     * @param gid - id of the goal that should be deleted
     * @return Http status code
     */
    @Override
    public HttpStatus deleteGoal(Long gid) {
        if (goalRepository.existsById(gid)) {
            goalRepository.delete(goalRepository.getOne(gid));
            goalRepository.flush();
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
