package com.github.m1santhrop.lovetelegrambot.repository;

import com.github.m1santhrop.lovetelegrambot.repository.entity.Compliment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ComplimentRepository extends JpaRepository<Compliment, Integer> {
    
    @Query(value = "SELECT * FROM Compliment c OFFSET floor(random() * :tableSize) LIMIT 1", nativeQuery = true)
    Compliment findRandomCompliment(@Param("tableSize") long tableSize);
}
