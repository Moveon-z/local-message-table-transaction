package cool.moveon.lmt.demo.service;

import com.google.gson.Gson;
import cool.moveon.lmt.demo.entity.Order;
import cool.moveon.lmt.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @KafkaListener(topics = "test", groupId = "moveon")
    public void handlerOrderEvent(String message) {
        Gson gson = new Gson();
        Message msg = gson.fromJson(message, Message.class);
        // 判断是否处理过
        if ("ACKNOWLEDGED".equals(msg.getStatus())) {
            return;
        }

        // 处理订单
        Order order = gson.fromJson(msg.getMessageBody(), Order.class);
        order.setStatus("SUCCESS");

    }
}
