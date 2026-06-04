package com.rmro.viva.config;

import com.rmro.viva.util.DataSeeder;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DataSeeder seeder = new DataSeeder();
        seeder.seed();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
