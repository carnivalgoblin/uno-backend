package com.allianztalents.unobackend.repository;

import com.allianztalents.unobackend.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
