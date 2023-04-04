package com.acme.sprocket.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import static org.slf4j.LoggerFactory.getLogger;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = {"com.acme.sprocket.*"})
public class Configuration {
    private static final Logger logger = getLogger(Configuration.class);

    @Autowired
    private Environment environment;


}
