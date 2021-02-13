//package com.prueba.bcp.handdlers;
//
//import org.springframework.http.MediaType;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Mono;
//
//public class Entrada {
//    
//    public Mono<ServerResponse> pulso(ServerRequest request) {
//	    return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
//	      .body(BodyInserters.fromValue("Prueba"));
//	  }
//
//}
