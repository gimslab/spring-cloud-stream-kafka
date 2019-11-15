package com.gimslab.springcloudstreamkafka.greetings;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Greetings {
	private long timestamp;
	private String message;

	public Greetings addPerson(String person) {
		return Greetings.builder()
				.timestamp(timestamp)
				.message(message + " " + person + " !!")
				.build();
	}
}
