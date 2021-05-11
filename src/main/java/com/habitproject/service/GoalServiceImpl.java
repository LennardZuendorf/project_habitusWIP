package com.habitproject.service;

import com.habitproject.persistence.goal.GoalEntity;
import com.habitproject.persistence.goal.GoalRepository;
import com.habitproject.web.goal.GoalRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalServiceImpl implements GoalService{

    private final GoalRepository goalRepository;
    public GoalServiceImpl(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
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
     * updating a GoalEntity in the database
     * @param gid          - id of the goal to update
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

}
