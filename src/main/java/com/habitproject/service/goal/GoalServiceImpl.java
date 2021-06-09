package com.habitproject.service.goal;

import com.habitproject.persistence.goal.GoalEntity;
import com.habitproject.persistence.goal.GoalRepository;
import com.habitproject.web.goal.GoalListStatusReturn;
import com.habitproject.web.goal.GoalRequestModel;
import com.habitproject.web.goal.GoalStatusReturn;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class GoalServiceImpl implements GoalService{

    private final GoalRepository repository;
    public GoalServiceImpl(GoalRepository repository) {
        this.repository = repository;
    }

    //services for goal API endpoints
    /**
     * saving a new goal to database
     * @param requestBody - all of GoalEntity params
     * @return GoalStatusReturn - combination of entity and status
     */
    @Override
    public GoalStatusReturn postGoal(GoalRequestModel requestBody) {
        GoalEntity newGoal = new GoalEntity(requestBody.getTag(), requestBody.getMeasure(), requestBody.getCurrentAmount(), requestBody.getTotalAmount(), requestBody.getUid(), requestBody.getLastCheck());
        repository.saveAndFlush(newGoal);
        return new GoalStatusReturn(newGoal, HttpStatus.CREATED);
    }

    /**
     * getting one GoalEntity by id
     * @param gid - the goal id to select by
     * @return GoalStatusReturn - combination of entity and status
     */
    @Override
    public GoalStatusReturn getGoal(Long gid) {
        if (repository.existsById(gid))return new GoalStatusReturn(repository.findFirstByGid(gid), HttpStatus.OK);
        else return new GoalStatusReturn(null, HttpStatus.NO_CONTENT);
    }

    /**
     * getting a list of all goals by UserID
     * @param uid - the user ID to be selected by
     * @return GoalListStatusReturn - combination of List with entities and status
     */
    @Override
    public GoalListStatusReturn getAllGoal(Long uid) {
        if (repository.existsByUid(uid)) return new GoalListStatusReturn(repository.findAllByUid(uid), HttpStatus.OK);
        else return new GoalListStatusReturn(null, HttpStatus.NO_CONTENT);
    }

    /**
     * updating a GoalEntity in the database
     * @param gid          - id of the goal to update
     * @param requestBody - all of HabitEntity params
     * @return Http status code
     */
    @Override
    public HttpStatus putGoal(Long gid, GoalRequestModel requestBody) {
        if(repository.existsById(gid)){
            GoalEntity goalEntity = repository.findFirstByGid(gid);
            goalEntity.setTag(requestBody.getTag());
            goalEntity.setMeasure(requestBody.getMeasure());
            goalEntity.setCurrentAmount(requestBody.getCurrentAmount());
            goalEntity.setTotalAmount(requestBody.getTotalAmount());
            goalEntity.setLastCheck(requestBody.getLastCheck());
            repository.saveAndFlush(goalEntity);
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
        if (repository.existsById(gid)) {
            repository.delete(repository.getOne(gid));
            repository.flush();
            return HttpStatus.OK;
        } else return HttpStatus.NO_CONTENT;
    }

}
