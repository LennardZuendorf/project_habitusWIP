package com.habitproject.web;

import com.habitproject.persistence.HabitEntity;
import com.habitproject.service.AppService;
import com.habitproject.service.AppServiceImpl;
import com.habitproject.web.api.HabitRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: Catching Exceptions and creating custom errors
@RestController
public class RESTController {

    private final AppService service;
    public RESTController(AppServiceImpl service) {
        this.service = service;
    }

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

    //TODO 1: fixing postman errors

    /**
     * API call for getting a habit (HabitEntity) by id
     * @param habitId - the habit id to select
     * @return status, json
     */
    @GetMapping("/habit/get")
    public ResponseEntity <HabitEntity> getHabit(@RequestParam Long habitId){
        var output = service.getHabit(habitId);
        return ResponseEntity.ok(output);
    }

    /**
     * API call for getting all habits (HabitEntity) by userID
     * @param userId - the user ID to be selected by
     * @return status, json
     */
    @GetMapping("/habit/get-all")
    public ResponseEntity <List<HabitEntity>> getAllHabit(@RequestParam Long userId){
        var output = service.getAllHabit(userId);
        return ResponseEntity.ok(output);
    }

    //TODO 3: fixing postman errors - wrong status code
    /**
     * API call for updating goal (GoalEntity)
     * @param habitId - id of the HabitEntry to add
     * @param requestBody - all of HabitEntity params
     * @return status code
     */
    @PatchMapping("/habit/put")
    HttpStatus putHabit(@RequestParam Long habitId, @RequestBody HabitRequestModel requestBody){
        return service.putHabit(habitId, requestBody);
    }

    //TODO 2: fixing postman errors - wrong status code
    /**
     * API call for deleting a habit (HabitEntity)
     * @param habitId - id of the habit that should be deleted
     * @return status code
     */
    @DeleteMapping("/habit/delete")
    HttpStatus deleteHabit (@RequestParam Long habitId){
        return service.deleteHabit(habitId);
    }
}
