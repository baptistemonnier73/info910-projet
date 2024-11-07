package org.usmb.bmonnier.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(value = "org.usmb.bmonnier.infrastructure.entities")
@EnableJpaRepositories(value = "org.usmb.bmonnier.infrastructure.jpa")
public class PersistenceConfiguration {

}