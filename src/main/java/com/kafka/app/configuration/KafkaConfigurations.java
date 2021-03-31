package com.kafka.app.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("kafka-config")
@Data
@Component
public class KafkaConfigurations {
    private String serverId;
    private String groupId;
    private String topicName;
}
