package com.acme.sprocket.configuration;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import static org.slf4j.LoggerFactory.getLogger;

@org.springframework.context.annotation.Configuration
@PropertySources({@PropertySource("classpath:application.properties")})
@ComponentScan(basePackages = {"com.acme.sprocket.*"})
public class Configuration {
    private static final Logger logger = getLogger(Configuration.class);

    @Autowired
    private Environment environment;

}
