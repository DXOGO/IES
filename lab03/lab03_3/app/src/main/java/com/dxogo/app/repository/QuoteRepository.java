package com.dxogo.app.repository;

import com.dxogo.app.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote,Integer> {
    Quote findByAvaliacao(String title);
}