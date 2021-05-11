package com.habitproject.web.habit;

import com.habitproject.persistence.habit.HabitEntity;
import com.habitproject.service.AppService;
import com.habitproject.service.AppServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HabitRESTController {

    private final AppService service;
    public HabitRESTController(AppServiceImpl service) {
        this.service = service;
    }

    //Habit API Endpoints
    /**
     * API call for creating a new habit (HabitEntity)
     * @param requestBody - all of HabitEntity params
     * @return status code, json
     */
    @PostMapping("/habits")
    public HttpStatus postHabit(@RequestBody HabitRequestModel requestBody){
        return service.postHabit(requestBody);
    }

    /**
     * API call for getting a habit (HabitEntity) by id
     * @param hid - the habit id to select
     * @return status, json
     */
    @GetMapping("/habits/{hid}")
    public ResponseEntity<HabitEntity> getHabit(@PathVariable Long hid){
        var output = service.getHabit(hid);
        return ResponseEntity.ok(output);
    }

    /**
     * API call for getting all habits (HabitEntity) by userID
     * @param uid - the user ID to be selected by
     * @return status, json
     */
    @GetMapping("/habits")
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
    @PutMapping("/habits/{hid}")
    public HttpStatus putHabit(@PathVariable Long hid, @RequestBody HabitRequestModel requestBody){
        return service.putHabit(hid, requestBody);
    }

    /**
     * API call for deleting a habit (HabitEntity)
     * @param hid - id of the habit that should be deleted
     * @return status code
     */
    @DeleteMapping("/habits/{hid}")
    public ResponseEntity <Void> deleteHabit (@PathVariable Long hid){
        var status = service.deleteHabit(hid);
        return ResponseEntity.status(status).build();
    }
}
