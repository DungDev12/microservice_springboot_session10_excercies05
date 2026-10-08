package com.exam.pharmacyservice;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopic;

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public String getDefaultTopic() {
        return defaultTopic;
    }
}
