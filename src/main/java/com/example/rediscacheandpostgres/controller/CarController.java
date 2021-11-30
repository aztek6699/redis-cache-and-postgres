package com.example.rediscacheandpostgres.controller;

import com.example.rediscacheandpostgres.model.CarDto;
import com.example.rediscacheandpostgres.postgres.CarJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarJpaRepo carJpaRepo;
    // HashOperations<KEY, ID, TYPE>
    private final HashOperations<String, Long, CarDto> carHashOperations;

    @Value("${redis.key.car}")
    private String carKey;

    public CarController(@Autowired CarJpaRepo carJpaRepo, @Autowired RedisTemplate<String, CarDto> redisTemplate) {
        this.carJpaRepo = carJpaRepo;
        this.carHashOperations = redisTemplate.opsForHash();
    }

    @GetMapping("/{id}")
    public CarDto getById(@PathVariable Long id) {
        CarDto carDto = carHashOperations.get(carKey, id);
        System.out.println("................");
        if (carDto != null) {
            System.out.println("got from cache");
            return carDto;
        } else {
            return carJpaRepo.findById(id).orElseGet(CarDto::new);
        }
    }

    @PostMapping
    public String insert(@RequestBody CarDto car) {
        carHashOperations.put(carKey, car.getId(), car);
        carJpaRepo.save(car);
        return "done";
    }
}
