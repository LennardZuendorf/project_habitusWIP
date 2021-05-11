package com.habitproject.web.user;

import com.habitproject.service.UserService;
import com.habitproject.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRESTController {

    private final UserService service;
    public UserRESTController(UserServiceImpl service) {
        this.service = service;
    }

    //User API Endpoints
    /**
     * API call for creating a user (UserAccountEntity)
     * @param requestBody - all of UserAccountEntity Params
     * @return status code
     */
    @PostMapping("/users")
    public HttpStatus postUser(@RequestBody UserRequestModel requestBody){
        return service.postUser(requestBody);
    }

    /**
     * API call for creating a user (UserAccountEntity)
     * @param uid - id of the UserAccountEntity to change
     * @param requestBody - all of UserAccountEntity Params
     * @return status code
     */
    @PutMapping("/users/{uid}")
    public HttpStatus putUser(@PathVariable Long uid, @RequestBody UserRequestModel requestBody){
        return service.putUser(uid, requestBody);
    }

    /**
     * API call for creating a user (UserAccountEntity)
     * @param uid - id of the UserAccountEntity to delete
     * @return status code
     */
    @DeleteMapping("/users/{uid}")
    public HttpStatus deleteUser(@PathVariable Long uid){
        return service.deleteUser(uid);
    }
}