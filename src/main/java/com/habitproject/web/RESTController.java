package com.habitproject.web;

import com.habitproject.persistence.GoalEntity;
import com.habitproject.persistence.HabitEntity;
import com.habitproject.service.AppService;
import com.habitproject.service.AppServiceImpl;
import com.habitproject.web.api.GoalRequestModel;
import com.habitproject.web.api.HabitRequestModel;
import com.habitproject.web.api.UserRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO 1: Catching Exceptions and creating custom errors
//TODO 2: fixing postman errors - wrong status code
@RestController
public class RESTController {

    private final AppService service;
    public RESTController(AppServiceImpl service) {
        this.service = service;
    }

    //Habit API Endpoints
    /**
     * API call for creating a new habit (HabitEntity)
     * @param requestBody - all of HabitEntity params
     * @return status code, json
     */
    @PostMapping("/habit/post")
    public ResponseEntity <HabitEntity> postHabit(@RequestBody HabitRequestModel requestBody){
        var output = service.postHabit(requestBody);
        return ResponseEntity.ok(output);
    }

    /**
     * API call for getting a habit (HabitEntity) by id
     * @param hid - the habit id to select
     * @return status, json
     */
    @GetMapping("/habit/get")
    public ResponseEntity <HabitEntity> getHabit(@RequestParam Long hid){
        var output = service.getHabit(hid);
        return ResponseEntity.ok(output);
    }

    /**
     * API call for getting all habits (HabitEntity) by userID
     * @param uid - the user ID to be selected by
     * @return status, json
     */
    @GetMapping("/habit/get-all")
    public ResponseEntity <List<HabitEntity>> getAllHabit(@RequestParam Long uid){
        var output = service.getAllHabit(uid);
        return ResponseEntity.ok(output);
    }

    /**
     * API call for updating habit (HabitEntity)
     * @param hid - id of the HabitEntry to add
     * @param requestBody - all of HabitEntity params
     * @return status code
     */
    @PutMapping("/habit/put")
    public HttpStatus putHabit(@RequestParam Long hid, @RequestBody HabitRequestModel requestBody){
        return service.putHabit(hid, requestBody);
    }

    /**
     * API call for deleting a habit (HabitEntity)
     * @param hid - id of the habit that should be deleted
     * @return status code
     */
    @DeleteMapping("/habit/delete")
    public HttpStatus deleteHabit (@RequestParam Long hid){
        return service.deleteHabit(hid);
    }


    //Goal API Endpoints
    /**
     * API call for creating a new goal (GoalEntity)
     * @param requestBody - all of GoalEntity params
     * @return status code, json
     */
    @PostMapping("/goal/post")
    public HttpStatus postGoal(@RequestBody GoalRequestModel requestBody){
        return service.postGoal(requestBody);
    }

    /**
     * API call for getting a goal (GoalEntity) by id
     * @param gid - the goal id to select
     * @return status code
     */
    @GetMapping("/goal/get")
    public ResponseEntity <GoalEntity> getGoal(@RequestParam Long gid){
        var output = service.getGoal(gid);
        return ResponseEntity.ok(output);
    }

    /**
     * API call for getting all goal (GoalEntity) by userID
     * @param uid - the user ID to be selected by
     * @return status, json
     */
    @GetMapping("/goal/get-all")
    public ResponseEntity <List<GoalEntity>> getAllGoal(@RequestParam Long uid){
        var output = service.getAllGoal(uid);
        return ResponseEntity.ok(output);
    }

    /**
     * API call for updating goal (GoalEntity)
     * @param gid - id of the GoalEntity to add
     * @param requestBody - all of GoalEntity params
     * @return status code
     */
    @PutMapping("/goal/put")
    HttpStatus putHabit(@RequestParam Long gid, @RequestBody GoalRequestModel requestBody){
        return service.putGoal(gid, requestBody);
    }

    /**
     * API call for deleting a goal (GoalEntity)
     * @param gid - id of the goal that should be deleted
     * @return status code
     */
    @DeleteMapping("/goal/delete")
    public HttpStatus deleteGoal(@RequestParam Long gid){
        return service.deleteGoal(gid);
    }


    //User API Endpoints
    /**
     * API call for creating a user (UserAccountEntity)
     * @param requestBody - all of UserAccountEntity Params
     * @return status code
     */
    @PostMapping("/user/post")
    public HttpStatus postUser(@RequestBody UserRequestModel requestBody){
        return service.postUser(requestBody);
    }

    /**
     * API call for creating a user (UserAccountEntity)
     * @param uid - id of the UserAccountEntity to change
     * @param requestBody - all of UserAccountEntity Params
     * @return status code
     */
    @PutMapping("/user/put")
    public HttpStatus putUser(@RequestParam Long uid, @RequestBody UserRequestModel requestBody){
        return service.putUser(uid, requestBody);
    }

    /**
     * API call for creating a user (UserAccountEntity)
     * @param uid - id of the UserAccountEntity to delete
     * @return status code
     */
    @DeleteMapping("/user/delete")
    public HttpStatus deleteUser(@RequestParam Long uid){
        return service.deleteUser(uid);
    }
}
