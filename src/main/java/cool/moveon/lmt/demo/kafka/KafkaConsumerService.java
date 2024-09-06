package cool.moveon.lmt.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

//    @KafkaListener(topics = "test", groupId = "moveon")
//    public void listen(String message) {
//        System.out.println("--------------------------接收到了消息：" + message);
//    }
}
