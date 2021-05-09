package com.habitproject.web;

import com.habitproject.persistence.HabitEntity;
import com.habitproject.persistence.HabitQuantity;
import com.habitproject.service.AppService;
import com.habitproject.service.AppServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;


@RestController
public class RESTController {

    private final AppService service = new AppServiceImpl();

    /**
     * API call for creating a new habit (HabitEntity)
     * @param tag - a tag for the habit (name)
     * @param quantity - quantity of the habit
     * @param frequency - the frequency a habit should be reached
     * @return status, json
     */

    @PutMapping("/habit/put")
    public ResponseEntity <HabitEntity> putHabit(String tag, HabitQuantity quantity, Integer frequency){
        var output = service.putHabit();
        return ResponseEntity.ok(output);
    }

    /**
     * API call for getting a habit (HabitEntity) by id
     * @param habitId - the habit id to select
     * @return status, json
     */
    @PutMapping("/habit/get")
    public ResponseEntity <HabitEntity> getHabit(Long habitId){
        var output = service.getHabit();
        return ResponseEntity.ok(output);
    }

    /**
     * API call for getting all habits (HabitEntity) by userID
     * @param userId - the user ID to be selected by
     * @return status, json
     */
    @PutMapping("/habit/getall")
    public ResponseEntity <List<HabitEntity>> getAllHabit(Long userId){
        var output = service.getAllHabit();
        return ResponseEntity.ok(output);
    }

    /**
     * API call for updating goal (GoalEntity)
     * @param tag - the goals (new) tag
     * @param quantity - the goals (new) quantity
     * @param currentAmount - the goals (new) Amount
     * @param totalAmount - the goals (new) totalAmount
     * @return status code, json
     */
    @PutMapping("/habit/update")
    ResponseEntity <HabitEntity> updateHabit(String tag, String quantity, BigDecimal currentAmount, BigDecimal totalAmount){
        var output = service.updateHabit();
        return ResponseEntity.ok(output);
    }

    /**
     * API call for deleting a habit (HabitEntity)
     * @param id - id of the habit that should be deleted
     * @return status, json
     */
    @PutMapping("/habit/delete")
    ResponseEntity <HabitEntity> deleteHabit(Long id){
        var output = service.deleteHabit();
        return ResponseEntity.ok(output);
    }
}
