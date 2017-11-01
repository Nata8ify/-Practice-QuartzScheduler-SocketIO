package com.arms.socket.controller;


import java.util.concurrent.TimeUnit;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.arms.model.Greeting;
import com.arms.model.HelloMessage;

@Controller
public class GreetingController {
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws InterruptedException{
		TimeUnit.MILLISECONDS.sleep(100);
		return new Greeting("Say Pal! ".concat(message.getName()));
	}
}
