package com.prueba.bcp.pojo;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@IdClass(ExchangeId.class)
public class Exchange {
   
    @Id
    @Temporal(TemporalType.DATE)
    private Date   day;
    private Double value;
    @Id
    private String mon;
    
//    public Exchange(Date day, Double value, String mon) {
//	super();
//	this.day = day;
//	this.value = value;
//	this.mon = mon;
//    }
//    
    
    

}
