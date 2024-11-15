package ru.skillfactorydemo.tgbot3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skillfactorydemo.tgbot3.entity.Spend;

@Repository
public interface SpendRepository  extends JpaRepository<Spend,Long> {
}
