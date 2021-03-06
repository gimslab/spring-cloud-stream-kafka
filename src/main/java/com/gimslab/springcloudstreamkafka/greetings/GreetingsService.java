package com.gimslab.springcloudstreamkafka.greetings;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GreetingsService {

	private final GreetingsStreams greetingsStreams;

	public GreetingsService(GreetingsStreams greetingsStreams) {
		this.greetingsStreams = greetingsStreams;
	}

	public void sendGreeting(final Greetings greetings){
		log.info("Sending greetings {}", greetings);
		
		MessageChannel messageChannel = greetingsStreams.outboundGreetings();
		Message<Greetings> message = MessageBuilder
			.withPayload(greetings)
			.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
			.build();
		log.info("Sending greetings message = {}", message);

		messageChannel.send(message);
	}
}
