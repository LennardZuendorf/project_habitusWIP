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
    public ResponseEntity <GoalEntity> postGoal(@RequestBody GoalRequestModel requestBody){
        var output = service.postGoal(requestBody);
        return ResponseEntity.status(output.getStatus()).body(output.getResponse());
    }

    /**
     * API call for getting a goal (GoalEntity) by id
     * @param gid - the goal id to select
     * @return status code, json
     */
    @GetMapping("/goals/{gid}")
    public ResponseEntity <GoalEntity> getGoal(@PathVariable Long gid){
        var output = service.getGoal(gid);
        return ResponseEntity.status(output.getStatus()).body(output.getResponse());
    }

    /**
     * API call for getting all goals (GoalEntity) by userID
     * @param uid - the user ID to be selected by
     * @return status code, json
     */
    @GetMapping("/goals/all/{uid}")
    public ResponseEntity <List<GoalEntity>> getAllGoal(@PathVariable Long uid){
        var output = service.getAllGoal(uid);
        return ResponseEntity.status(output.getStatus()).body(output.getResponse());
    }

    /**
     * API call for updating goal (GoalEntity)
     * @param gid - id of the GoalEntity to add
     * @param requestBody - all of GoalEntity params
     * @return status code
     */
    @PutMapping("/goals/{gid}")
    public ResponseEntity <Void>  putHabit(@PathVariable Long gid, @RequestBody GoalRequestModel requestBody){
        return ResponseEntity.status(service.putGoal(gid, requestBody)).build();
    }

    /**
     * API call for deleting a goal (GoalEntity)
     * @param gid - id of the goal that should be deleted
     * @return status code
     */
    @DeleteMapping("/goals/{gid}")
    public ResponseEntity <Void> deleteGoal(@PathVariable Long gid){
        return ResponseEntity.status(service.deleteGoal(gid)).build();
    }
}
