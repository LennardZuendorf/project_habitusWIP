package com.habitproject.configuration;

public class Endpoints {

    //REST API Endpoints
    public static class Rest{

        //Habit Endpoints
        public static final String HABITS = "/habits/**";
        public static final String HABITS_GET_ALL = "/habits/all/**";

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
