package com.habitproject.web;

import com.habitproject.persistence.HabitEntity;
import com.habitproject.service.AppService;
import com.habitproject.service.AppServiceImpl;
import com.habitproject.web.api.HabitRequestModel;
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
    HttpStatus putHabit(@RequestParam Long hid, @RequestBody HabitRequestModel requestBody){
        return service.putHabit(hid, requestBody);
    }


    /**
     * API call for deleting a habit (HabitEntity)
     * @param hid - id of the habit that should be deleted
     * @return status code
     */
    @DeleteMapping("/habit/delete")
    HttpStatus deleteHabit (@RequestParam Long hid){
        return service.deleteHabit(hid);
    }
}
