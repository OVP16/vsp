package com.prueba.bcp.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class ExchangeId  implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Date   day;
    private String mon;
}
