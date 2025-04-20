package com.streamwikimedia.configs;


import com.streamwikimedia.entity.WikiMediaDataEntity;
import com.streamwikimedia.repository.WikiMediaDataRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListeners {
    private static final Logger log = LoggerFactory.getLogger(KafkaListeners.class);

    @Autowired
    private WikiMediaDataRepo wikiMediaDataRepo;

    @KafkaListener(topics = "wikimedia_recent_change",groupId = "myGroup")
    public void consume(String eventMessage){

        try {
            log.info("Message received: {}", eventMessage);
            WikiMediaDataEntity data = new WikiMediaDataEntity();
            data.setWikiEventData(eventMessage);
            wikiMediaDataRepo.save(data);
        } catch (Exception e) {
            log.error("Exception during receiving and saving the message: {}", e.getMessage());
        }
    }
}
