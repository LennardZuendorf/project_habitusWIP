package com.habitproject.web.goal;

import com.habitproject.persistence.goal.GoalEntity;
import com.habitproject.service.goal.GoalService;
import com.habitproject.service.goal.GoalServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO 1: Catching Exceptions and creating custom errors
//TODO 2: fixing postman errors - wrong status code
@RestController
public class GoalRESTController {

    private final GoalService service;
    public GoalRESTController(GoalServiceImpl service) {
        this.service = service;
    }

    //Goal API Endpoints
    /**
     * API call for creating a new goal (GoalEntity)
     * @param requestBody - all of GoalEntity params
     * @return status code, json
     */
    @PostMapping("/goals")
    public HttpStatus postGoal(@RequestBody GoalRequestModel requestBody){
        return service.postGoal(requestBody);
    }

    /**
     * API call for getting a goal (GoalEntity) by id
     * @param gid - the goal id to select
     * @return status code
     */
    @GetMapping("/goals/{gid}")
    public ResponseEntity <GoalEntity> getGoal(@PathVariable Long gid){
        var output = service.getGoal(gid);
        return ResponseEntity.ok(output);
    }

    /**
     * API call for getting all goals (GoalEntity) by userID
     * @param uid - the user ID to be selected by
     * @return status, json
     */
    @GetMapping("/goals/{uid}")
    public ResponseEntity <List<GoalEntity>> getAllGoal(@PathVariable Long uid){
        var output = service.getAllGoal(uid);
        return ResponseEntity.ok(output);
    }

    /**
     * API call for updating goal (GoalEntity)
     * @param gid - id of the GoalEntity to add
     * @param requestBody - all of GoalEntity params
     * @return status code
     */
    @PutMapping("/goals/{gid}")
    public HttpStatus putHabit(@PathVariable Long gid, @RequestBody GoalRequestModel requestBody){
        return service.putGoal(gid, requestBody);
    }

    /**
     * API call for deleting a goal (GoalEntity)
     * @param gid - id of the goal that should be deleted
     * @return status code
     */
    @DeleteMapping("/goals/{gid}")
    public HttpStatus deleteGoal(@PathVariable Long gid){
        return service.deleteGoal(gid);
    }
}
