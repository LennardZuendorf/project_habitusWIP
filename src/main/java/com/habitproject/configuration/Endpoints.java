package com.habitproject.configuration;

public class Endpoints {

    //REST API Endpoints
    public static class Rest{

        //Goal Endpoints
        public static final String GOALS = "/goals";
        public static final String GOALS_GET = "/goals/";
        public static final String GOALS_GET_ALL = "/goals/all/";
        public static final String GOALS_PUT = "/goals/";
        public static final String GOALS_DELETE = "/goals/";

        //Habit Endpoints
        public static final String HABITS = "/habits";
        public static final String HABITS_GET = "/habits/";
        public static final String HABITS_GET_ALL = "/habits/all/";
        public static final String HABITS_PUT = "/habits/";
        public static final String HABITS_DELETE = "/habits/";

    }

    //Site Endpoints
    public static class Site{
        public static final String INDEX = "/home";
        public static final String SLASH = "/";
        public static final String LOGIN = "/login";
        public static final String DASH = "/dashboard";
        public static final String TEST= "/test";
        public static final String ERROR= "/error";

    }
}
