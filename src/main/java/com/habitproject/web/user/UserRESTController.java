package com.habitproject.web.user;

import com.habitproject.persistence.user.UserAccountEntity;
import com.habitproject.service.user.UserService;
import com.habitproject.service.user.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * @return status code, json
     */
    @PostMapping("/users")
    public ResponseEntity <UserAccountEntity> postUser (@RequestBody UserRequestModel requestBody){
        var output = service.postUser(requestBody);
        return ResponseEntity.status(output.getStatus()).body(output.getResponse());
    }

    /**
     * API call for creating a user (UserAccountEntity)
     * @param uid - id of the UserAccountEntity to change
     * @param requestBody - all of UserAccountEntity Params
     * @return status code
     */
    @PutMapping("/users/{uid}")
    public ResponseEntity <Void> putUser(@PathVariable Long uid, @RequestBody UserRequestModel requestBody){
        return ResponseEntity.status(service.putUser(uid, requestBody)).build();
    }

    /**
     * API call for creating a user (UserAccountEntity)
     * @param uid - id of the UserAccountEntity to delete
     * @return status code
     */
    @DeleteMapping("/users/{uid}")
    public ResponseEntity <Void> deleteUser(@PathVariable Long uid){
        return ResponseEntity.status(service.deleteUser(uid)).build();
    }
}