package ru.skillfactorydemo.tgbot3.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.skillfactorydemo.tgbot3.entity.Spend;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class SpendRepositoryTest {

    @Autowired
    private SpendRepository spendRepository;

    @Test
    public void testRepo() {
        //before this test cycle execute some insertion from test/import.sql
        //noinspection StatementWithEmptyBody
        List<Spend> found = spendRepository.findAll();
        int importInsertCount = found.size();
        int maxTestStep = 10;
        if (maxTestStep > importInsertCount) {
            for (int i = 0; i < (maxTestStep - importInsertCount); i++, spendRepository.save(new Spend())) ;
        }
        found = spendRepository.findAll();
        assertEquals(10, found.size());
    }

}
