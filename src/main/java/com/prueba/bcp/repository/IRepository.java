package com.prueba.bcp.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.bcp.pojo.Exchange;

@Repository
public interface IRepository extends  JpaRepository <Exchange, String>{
    
    List<Exchange> findAll();
    Optional<Exchange> findByDayAndMon(Date date, String mon);
    List<Exchange> findByValue(Double nose);
}
