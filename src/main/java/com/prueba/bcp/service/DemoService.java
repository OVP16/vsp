package com.prueba.bcp.service;

import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.bcp.pojo.Exchange;
import com.prueba.bcp.pojo.ExchangeResponse;
import com.prueba.bcp.repository.IRepository;

import rx.Single;

@Service
public class DemoService {

    @Autowired
    IRepository deptRepository;

    public Single<ExchangeResponse> obtenerMonto(Date date, String monOrigin, String monFinal, Double monto) {
	return Single.create(singleSubscriber -> {
	    Optional<Exchange> valorOrigin = deptRepository.findByDayAndMon(date == null ? new Date() : date, monOrigin.toUpperCase());
	    Optional<Exchange> valorFinal = deptRepository.findByDayAndMon(date == null ? new Date() : date, monFinal.toUpperCase());
	    if (!valorOrigin.isPresent() || !valorFinal.isPresent())
		singleSubscriber.onError(new EntityNotFoundException());
	    else {
		Double tasa =valorFinal.get().getValue()/valorOrigin.get().getValue();
		singleSubscriber.onSuccess(
			new ExchangeResponse(date, monto, valorOrigin.get().getMon(), monto * tasa, valorFinal.get().getMon(), tasa));
	    }
	});
    }

//    public Single<String> actualizar(Date date, String mon, Double value) {
//	return Single.create(singleSubscriber -> {
//	    Exchange ingreso = deptRepository.save(new Exchange(date, value, mon));
//
//	    if (ingreso == null)
//		singleSubscriber.onError(new EntityNotFoundException());
//	    else {
//		singleSubscriber.onSuccess("Ok");
//	    }
//	});
//    }

    public ExchangeResponse obtenerMontoRest(Date date, String monOrigin, String monFinal, Double monto) {

	Optional<Exchange> valorOrigin = deptRepository.findByDayAndMon(date == null ? new Date() : date, monOrigin.toUpperCase());
	Optional<Exchange> valorFinal = deptRepository.findByDayAndMon(date == null ? new Date() : date, monFinal.toUpperCase());
	if (!valorOrigin.isPresent() || !valorFinal.isPresent()) {
	    System.out.println("asd");
	    return new ExchangeResponse();
	} else {
	    Double tasa = valorOrigin.get().getValue() / valorFinal.get().getValue();
	    return new ExchangeResponse(date, monto, valorOrigin.get().getMon(), monto * tasa, valorFinal.get().getMon(), tasa);
	}
    };
}
