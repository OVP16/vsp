package com.prueba.bcp.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

//@Data
public class ExchangeResponse {

    private Date   day;
    private Double valueOri;
    private String monOrigen;
    private Double valueFinal;
    private String monFinal;
    private Double exchange;
    
    
    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Double getValueOri() {
        return valueOri;
    }

    public void setValueOri(Double valueOri) {
        this.valueOri = valueOri;
    }

    public String getMonOrigen() {
        return monOrigen;
    }

    public void setMonOrigen(String monOrigen) {
        this.monOrigen = monOrigen;
    }

    public Double getValueFinal() {
        return valueFinal;
    }

    public void setValueFinal(Double valueFinal) {
        this.valueFinal = valueFinal;
    }

    public String getMonFinal() {
        return monFinal;
    }

    public void setMonFinal(String monFinal) {
        this.monFinal = monFinal;
    }

    public Double getExchange() {
        return exchange;
    }

    public void setExchange(Double exchange) {
        this.exchange = exchange;
    }
    
    public ExchangeResponse() {
	
    }
    
    public ExchangeResponse(Date day, Double valueOri, String monOrigen, Double valueFinal, String monFinal, Double exchange) {
	this.day = day;
	this.valueOri = valueOri;
	this.monOrigen = monOrigen;
	this.valueFinal = valueFinal;
	this.monFinal = monFinal;
	this.exchange = exchange;
    }
    
    
}
