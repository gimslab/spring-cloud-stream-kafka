package com.gimslab.springcloudstreamkafka.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.gimslab.springcloudstreamkafka.greetings.GreetingsStreams;

@EnableBinding(GreetingsStreams.class)
public class StreamConfig {
}
