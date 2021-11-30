package com.example.rediscacheandpostgres.postgres;

import com.example.rediscacheandpostgres.model.CarDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarJpaRepo extends JpaRepository<CarDto, Long> {
}
