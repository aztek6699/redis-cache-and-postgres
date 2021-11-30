package com.example.rediscacheandpostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
//@EnableConfigurationProperties
//@EntityScan("com.example.rediscacheandpostgres.model")
public class RedisCacheAndPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheAndPostgresApplication.class, args);
	}

}
