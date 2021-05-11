package com.habitproject.service.user;

import com.habitproject.persistence.user.UserAccountEntity;
import com.habitproject.persistence.user.UserRepository;
import com.habitproject.web.user.UserRequestModel;
import com.habitproject.web.user.UserStatusReturn;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * UserService is the class implementing the HabitApp's backend business logic, right now only for HabitEntities
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //services for user API endpoints
    /**
     * saving a new user (UserAccountEntity) to database
     * @param requestBody - all UserAccountEntity params
     * @return UserStatusReturn - combination of new Entity and status code
     */
    @Override
    public UserStatusReturn postUser(UserRequestModel requestBody) {
        UserAccountEntity newUser = new UserAccountEntity(requestBody.getUsername(), requestBody.getEmail());
        userRepository.saveAndFlush(newUser);
        return new UserStatusReturn(newUser, HttpStatus.CREATED);
    }

    /**
     * updating a HabitEntity in the database
     * @param uid - id of the user to update
     * @param requestBody - all UserAccountEntity params
     * @return HttpStatus code
     */
    @Override
    public HttpStatus putUser(Long uid, UserRequestModel requestBody) {
        if(userRepository.existsById(uid)){
            UserAccountEntity userEntry = userRepository.findFirstByUid(uid);
            userEntry.setUsername(requestBody.getUsername());
            userEntry.setEmail(requestBody.getEmail());
            userRepository.saveAndFlush(userEntry);
            return HttpStatus.OK;
        }else return HttpStatus.NO_CONTENT;
    }

    /**
     * API call for deleting a habit (HabitEntity)
     * @param uid - id of the user to delete
     * @return HttpStatus code
     */
    @Override
    public HttpStatus deleteUser(Long uid) {
        if (userRepository.existsById(uid)) {
            userRepository.delete(userRepository.getOne(uid));
            userRepository.flush();
            return HttpStatus.OK;
        } else return HttpStatus.NO_CONTENT;
    }
}
