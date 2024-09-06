package cool.moveon.lmt.demo.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Service
public class KafkaProduceService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final AdminClient adminClient;

    public KafkaProduceService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "101.132.108.250:9091, 101.132.108.250:9092, 101.132.108.250:9093");
        this.adminClient = AdminClient.create(props);
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    public boolean isTopicExists(String topicName) {
        try {
            ListTopicsResult topics = adminClient.listTopics();
            return topics.names().get().contains(topicName);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void createTopic(String topicName, int numPartitions, short replicationFactor) {
        NewTopic newTopic = new NewTopic(topicName, numPartitions, replicationFactor);
        try {
            adminClient.createTopics(Collections.singletonList(newTopic)).all().get();
            System.out.println("Topic created successfully: " + topicName);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            System.out.println("Failed to create topic: " + topicName);
        }
    }
}
