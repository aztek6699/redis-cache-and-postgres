package com.example.rediscacheandpostgres.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
@RedisHash("cars")
public class CarDto implements Serializable {

    @Id
    private Long id;
    private String company;
    private String model;
}
