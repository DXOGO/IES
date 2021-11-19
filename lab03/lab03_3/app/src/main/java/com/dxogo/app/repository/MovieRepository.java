package com.dxogo.app.repository;

import com.dxogo.app.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    Movie findByTitle(String title);
   // List<Quote> findBy
}
