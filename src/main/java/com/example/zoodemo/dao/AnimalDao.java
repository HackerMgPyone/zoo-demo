package com.example.zoodemo.dao;

import com.example.zoodemo.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalDao extends JpaRepository<Animal,Integer> {
}
