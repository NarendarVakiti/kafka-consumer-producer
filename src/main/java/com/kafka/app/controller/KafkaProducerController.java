package com.kafka.app.controller;

import com.kafka.app.configuration.KafkaConfigurations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaConfigurations kafkaConfigurations;

    @PostMapping("/writemessage/{message}")
    public String writeKafkaMessage(@PathVariable("message") String message){
        try {
            ListenableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(kafkaConfigurations.getTopicName(), message);

            future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
                /**
                 * Called when the {@link ListenableFuture} completes with success.
                 * <p>Note that Exceptions raised by this method are ignored.
                 *
                 * @param result the result
                 */
                @Override
                public void onSuccess(SendResult<String, String> result) {
                    log.info("published message successfully...");
                }
                @Override
                public void onFailure(Throwable ex) {
                    log.error("Exception occurred while publishing message", ex);
                    ex.printStackTrace();
                }
            });
            return "published message successfully... Message = "+message;
        } catch (Exception e) {
            log.error("Exception while publishing message", e);
            e.printStackTrace();
            return "published message failed...";
        }

    }
}
