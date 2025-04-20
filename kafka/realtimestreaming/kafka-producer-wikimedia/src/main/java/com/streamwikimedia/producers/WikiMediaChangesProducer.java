package com.streamwikimedia.producers;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.StreamException;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikiMediaChangesProducer {

    private static final Logger log = LoggerFactory.getLogger(WikiMediaChangesProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public WikiMediaChangesProducer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException, StreamException {
        String topic = "wikimedia_recent_change";

        // to read realtime stream data, we use event source
        BackgroundEventHandler eventHandler = new WikiMediaChangesHandler(topic, kafkaTemplate);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";


        EventSource.Builder builder = new EventSource.Builder(URI.create(url));

        BackgroundEventSource eventSource = new BackgroundEventSource.Builder(eventHandler,builder).build();


        eventSource.start();
        TimeUnit.MINUTES.sleep(5);


    }

}
