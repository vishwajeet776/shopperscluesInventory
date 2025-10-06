package com.shopperscluesInventory.shopperscluesInventory.Config;

import org.springframework.boot.actuate.health.DefaultHealthContributorRegistry;
import org.springframework.boot.actuate.health.HealthContributorRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HealthConfig {

    @Bean
    public HealthContributorRegistry healthContributorRegistry() {
        return new DefaultHealthContributorRegistry();
    }
}
