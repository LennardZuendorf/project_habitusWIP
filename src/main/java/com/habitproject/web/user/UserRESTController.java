package com.habitproject.web.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserRESTController {


    //User API Endpoints
    /**
     * API call for creating a user (UserAccountEntity)
     * @param requestBody - all of UserAccountEntity Params
     * @return status code, json
     */
    @PostMapping("/users")
    public String postUser (@RequestBody UserRequestModel requestBody){
        return null;
    }

    /**
     * API call for getting a user (HabitEntity)
     * @param uid - id of the UserAccountEntity to delete
     * @return status code, json
     */
    @GetMapping("/users/{uid}")
    public String getUser(@PathVariable Long uid){
        return null;
    }

    /**
     * API call for creating a user (UserAccountEntity)
     * @param uid - id of the UserAccountEntity to change
     * @param requestBody - all of UserAccountEntity Params
     * @return status code
     */
    @PutMapping("/users/{uid}")
    public String putUser(@PathVariable Long uid, @RequestBody UserRequestModel requestBody){
        return null;
    }

    /**
     * API call for creating a user (UserAccountEntity)
     * @param uid - id of the UserAccountEntity to delete
     * @return status code
     */
    @DeleteMapping("/users/{uid}")
    public String deleteUser(@PathVariable Long uid){
        return null;
    }
}