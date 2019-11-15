package com.gimslab.springcloudstreamkafka.greetings;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GreetingsListener {

	@StreamListener(GreetingsStreams.INPUT)
	@SendTo(GreetingsStreams.OUTPUT)
	public Greetings handleGreetings(@Payload Greetings greetings) {
		log.info("Received greetings: {}", greetings);
		return greetings.addPerson("Kim");
	}
}
