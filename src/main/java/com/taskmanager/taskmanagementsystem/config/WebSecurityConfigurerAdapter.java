package com.taskmanager.taskmanagementsystem.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public abstract class WebSecurityConfigurerAdapter {
    protected abstract void configure(HttpSecurity http) throws Exception;

    protected AuthenticationManager authenticationManagerBean() {
        return null;
    }
}
