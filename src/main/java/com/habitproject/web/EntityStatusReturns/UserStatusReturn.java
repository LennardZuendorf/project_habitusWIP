package com.habitproject.web.EntityStatusReturns;

import com.habitproject.persistence.user.UserAccountEntity;
import org.springframework.http.HttpStatus;

public class UserStatusReturn {

    UserAccountEntity response;
    HttpStatus status;

    public UserStatusReturn(UserAccountEntity response, HttpStatus status){
        this.response = response;
        this.status = status;
    }

    public UserAccountEntity getResponse() {
        return response;
    }
    public void setResponse(UserAccountEntity response) {
        this.response = response;
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
