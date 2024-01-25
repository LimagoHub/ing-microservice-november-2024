package com.example.kafkaemitter;


import com.example.kafkaemitter.emitter.EventEmitter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class MyRestController {
	

	
	private final EventEmitter emitter;





	@GetMapping("/fireEvent")
	public String fireEvent() {
		emitter.send("Hallo Event");
		return "Event fired";
	}
	

	@GetMapping("/version")
	public String getVersion() {
		return "1.0.0";
	}

}
