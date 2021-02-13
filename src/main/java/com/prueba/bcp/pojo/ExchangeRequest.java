package com.prueba.bcp.pojo;
import java.util.Date;
import lombok.Data;

//@Data
public class ExchangeRequest {
    private Date   day;
    private Double value;
    private String monOrigin;
    private String monFinal;
    public Date getDay() {
        return day;
    }
    public void setDay(Date day) {
        this.day = day;
    }
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public String getMonOrigin() {
        return monOrigin;
    }
    public void setMonOrigin(String monOrigin) {
        this.monOrigin = monOrigin;
    }
    public String getMonFinal() {
        return monFinal;
    }
    public void setMonFinal(String monFinal) {
        this.monFinal = monFinal;
    }

}
