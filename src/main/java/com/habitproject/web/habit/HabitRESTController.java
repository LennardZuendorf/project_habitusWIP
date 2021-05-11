package com.habitproject.web.habit;

import com.habitproject.persistence.habit.HabitEntity;
import com.habitproject.service.habit.HabitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HabitRESTController {

    private final HabitService service;
    public HabitRESTController( HabitService service) {
        this.service = service;
    }

    //Habit API Endpoints
    /**
     * API call for creating a new habit (HabitEntity)
     * @param requestBody - all of HabitEntity params
     * @return status code, json
     */
    @PostMapping("/habits")
    public ResponseEntity <HabitEntity> postHabit(@RequestBody HabitRequestModel requestBody){
        var output = service.postHabit(requestBody);
        return ResponseEntity.status(output.getStatus()).body(output.getResponse());
    }

    /**
     * API call for getting a habit (HabitEntity) by id
     * @param hid - the habit id to select
     * @return status code, json
     */
    @GetMapping("/habits/{hid}")
    public ResponseEntity <HabitEntity> getHabit(@PathVariable Long hid){
        var output = service.getHabit(hid);
        return ResponseEntity.status(output.getStatus()).body(output.getResponse());
    }

    /**
     * API call for getting all habits (HabitEntity) by userID
     * @param uid - the user ID to be selected by
     * @return status code, json
     */
    @GetMapping("/habits")
    public ResponseEntity <List<HabitEntity>> getAllHabit(@RequestParam Long uid){
        var output = service.getAllHabit(uid);
        return ResponseEntity.status(output.getStatus()).body(output.getResponse());
    }

    /**
     * API call for updating habit (HabitEntity)
     * @param hid - id of the HabitEntry to add
     * @param requestBody - all of HabitEntity params
     * @return status code
     */
    @PutMapping("/habits/{hid}")
    public ResponseEntity <Void> putHabit(@PathVariable Long hid, @RequestBody HabitRequestModel requestBody){
        return ResponseEntity.status(service.putHabit(hid, requestBody)).build();
    }

    /**
     * API call for deleting a habit (HabitEntity)
     * @param hid - id of the habit that should be deleted
     * @return status code
     */
    @DeleteMapping("/habits/{hid}")
    public ResponseEntity <Void> deleteHabit (@PathVariable Long hid){
        return ResponseEntity.status(service.deleteHabit(hid)).build();
    }
}
