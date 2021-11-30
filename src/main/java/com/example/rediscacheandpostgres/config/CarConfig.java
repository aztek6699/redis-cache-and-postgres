package com.example.rediscacheandpostgres.config;

import com.example.rediscacheandpostgres.model.CarDto;
import com.example.rediscacheandpostgres.postgres.CarJpaRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.List;

@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        transactionManagerRef = "carTransactionManager",
//        entityManagerFactoryRef = "carEntityManagerFactory",
//        basePackages = { "com.example.rediscacheandpostgres.postgres" }
//)
public class CarConfig {

//    @Bean(name="carDSProperties")
//    @ConfigurationProperties("spring.datasource")
//    public DataSourceProperties dataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Primary
//    @Bean(name = "carDataSource")
//    @ConfigurationProperties("spring.datasource")
//    public DataSource dataSource(@Qualifier("carDSProperties") DataSourceProperties properties) {
//        return properties.initializeDataSourceBuilder().build();
//    }
//
//    @Bean(name = "carEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean carEntityManagerFactory(
//            EntityManagerFactoryBuilder builder,
//            @Qualifier("carDataSource") DataSource sportDataSource
//    ) {
//        return
//                builder.dataSource(sportDataSource)
//                        .packages("com.example.rediscacheandpostgres.postgres")
//                        .persistenceUnit("car")
//                        .build();
//    }
//
//    @Bean(name = "carTransactionManager")
//    @ConfigurationProperties("car.jpa")
//    public PlatformTransactionManager carTransactionManager(
//            @Qualifier("carEntityManagerFactory") EntityManagerFactory
//                    carEntityManagerFactory
//    ) {
//        return new JpaTransactionManager(carEntityManagerFactory);
//    }

    @Bean
    CommandLineRunner commandLineRunner(CarJpaRepo repo) {
        return args -> {
            CarDto civic = new CarDto(1L, "Honda", "Civic");
            CarDto city = new CarDto(2L, "Honda", "City");

            CarDto corolla = new CarDto(3L, "Toyota", "Corolla");
            CarDto hilux = new CarDto(4L, "Toyota", "Hilux");

            CarDto mehran = new CarDto(5L, "Suzuki", "Mehran");
            CarDto khyber = new CarDto(6L, "Suzuki", "Khyber");
            CarDto cultus = new CarDto(7L, "Suzuki", "Cultus");

            repo.saveAll(
                    List.of(civic, city, corolla, hilux, mehran, khyber, cultus)
            );
        };
    }
}
