package com.habitproject.web.additions;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//solution found on HTW WI Slack

@Controller
public class DatabaseController {
    final Environment environment;

    public DatabaseController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/print")
    public String printJDBCCreds(){
        return environment.getProperty("JDBC_DATABASE_URL");
    }
}