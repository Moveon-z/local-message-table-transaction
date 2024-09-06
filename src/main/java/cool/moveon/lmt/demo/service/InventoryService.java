package cool.moveon.lmt.demo.service;

import com.google.gson.Gson;
import cool.moveon.lmt.demo.entity.Order;
import cool.moveon.lmt.demo.entity.Product;
import cool.moveon.lmt.demo.kafka.KafkaProduceService;
import cool.moveon.lmt.demo.mapper.ProductMapper;
import cool.moveon.lmt.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class InventoryService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void createProduct(Product product) {
        product.setCreateTime(new Timestamp(System.currentTimeMillis()));
        productMapper.insert(product);
    }

    @KafkaListener(topics = "order-to-inventory", groupId = "moveon")
    public void handlerOrderEvent(String message) {
        Gson gson = new Gson();
        Message msg = gson.fromJson(message, Message.class);

        // 处理订单
        Order order = gson.fromJson(msg.getMessageBody(), Order.class);
        Product product = productMapper.selectById(order.getProductId());
        product.setSurplusQuantity(product.getSurplusQuantity() - order.getPurchaseNum());
        productMapper.updateById(product);
        order.setStatus("SUCCESS");

        msg.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        msg.setMessageBody(gson.toJson(order));
        kafkaTemplate.send("inventory-to-order", gson.toJson(msg));
    }
}
