package com.p2engenharia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p2engenharia.model.Hamburguer;

@Repository
public interface HamburguerRepository extends JpaRepository<Hamburguer, Long> {

}
