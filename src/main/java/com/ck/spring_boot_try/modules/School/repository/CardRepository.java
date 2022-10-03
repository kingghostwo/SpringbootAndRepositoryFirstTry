package com.ck.spring_boot_try.modules.School.repository;

import com.ck.spring_boot_try.modules.School.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {


}
