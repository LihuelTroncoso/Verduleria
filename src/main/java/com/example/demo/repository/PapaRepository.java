package com.example.demo.repository;

import com.example.demo.domain.Papa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PapaRepository extends JpaRepository<Papa, Integer> {

}