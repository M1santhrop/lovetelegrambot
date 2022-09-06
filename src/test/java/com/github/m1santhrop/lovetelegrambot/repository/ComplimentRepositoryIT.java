package com.github.m1santhrop.lovetelegrambot.repository;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import com.github.m1santhrop.lovetelegrambot.repository.entity.Compliment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@DisplayName("Integration-level testing for ComplimentRepository")
class ComplimentRepositoryIT {

    @Autowired
    private ComplimentRepository complimentRepository;

    @Sql(scripts = {"/sql/clearDbs.sql", "/sql/someCompliments.sql"})
    @Test
    void shouldProperlyGetRandomCompliment() {
        long count = complimentRepository.count();
        for (int i = 0; i < 100; i++) {
            Compliment randomCompliment = complimentRepository.findRandomCompliment(count);
            System.out.println(randomCompliment.getDescription());
            Assertions.assertNotNull(randomCompliment);
        }
    }
}