package com.sethsites.cssi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * User: Seth Sites
 * Date: 2/14/18
 * Time: 5:13 PM
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.sethsites.cssi.repository"})
public class RepositoryConfig {
    
}
