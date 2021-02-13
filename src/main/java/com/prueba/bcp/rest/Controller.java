package com.prueba.bcp.rest;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.bcp.pojo.ExchangeRequest;
import com.prueba.bcp.pojo.ExchangeResponse;
import com.prueba.bcp.service.DemoService;

import rx.Single;
import rx.schedulers.Schedulers;


@RestController
public class Controller {

    @Autowired
    DemoService demoService;


    @GetMapping(value = "/prueba", produces = MediaType.APPLICATION_JSON_VALUE )
    public Single<ResponseEntity<ExchangeResponse>> prueba(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime  day, @RequestParam Double monto,
	    @RequestParam String monOrigin, @RequestParam String monFinal) {
	return demoService.obtenerMonto(day != null ? Date.from(day.toInstant()) : null, monOrigin, monFinal, monto).subscribeOn(Schedulers.io())
		.map(response -> ResponseEntity.ok(response));
    }
    
    @GetMapping(value = "/pruebarest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExchangeResponse> pruebaRest(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime  day, @RequestParam Double monto,
	    @RequestParam String monOrigin, @RequestParam String monFinal) {

	return new ResponseEntity<>(demoService.obtenerMontoRest(Date.from(day.toInstant()), monOrigin, monFinal, monto), HttpStatus.OK);
    }
    
//    @PostMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE )
//    public Single<ResponseEntity<String>> actualizar(@RequestBody ExchangeRequest request) {
//	return demoService.actualizar(request.getDay() == null ? null :request.getDay() , request.getMonOrigin(), request.getValue()).subscribeOn(Schedulers.io())
//		.map(response -> ResponseEntity.ok(response));
//    }
    
}
