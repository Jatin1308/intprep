package com.streamwikimedia.producers;

import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WikiMediaChangesHandler implements BackgroundEventHandler {

    private static final Logger log = LoggerFactory.getLogger(WikiMediaChangesHandler.class);
    public WikiMediaChangesHandler(String topic, KafkaTemplate<String, String> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;
    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        log.info("Event Data -> {}", messageEvent.getData());

        kafkaTemplate.send(topic, messageEvent.getData());

    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

        log.error("Error in streaming Wikimedia changes", throwable);

    }
}
