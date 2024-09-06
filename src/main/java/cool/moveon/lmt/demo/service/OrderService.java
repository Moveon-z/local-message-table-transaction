package cool.moveon.lmt.demo.service;

import com.google.gson.Gson;
import cool.moveon.lmt.demo.kafka.KafkaProduceService;
import cool.moveon.lmt.demo.mapper.MessageMapper;
import cool.moveon.lmt.demo.mapper.OrderMapper;
import cool.moveon.lmt.demo.entity.Order;
import cool.moveon.lmt.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @ClassName OrderService
 * @Description TODO
 * @Author Moveon
 * @Date 2024/9/3 18:27
 * @Version 1.0
 **/
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private KafkaProduceService kafkaProduceService;

    @Transactional
    public void createOrder(Order order) {
//        order.setUserId(1L);
//        order.setProductId(1L);
//        order.setAmount(BigDecimal.valueOf(9.9));
        order.setStatus("send");
        order.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        int i = orderMapper.insert(order);

        Message message = new Message();
        message.setObjId(order.getId());
        Gson gson = new Gson();
        message.setMessageBody(gson.toJson(order));
        message.setStatus("PENDING");
        message.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        messageMapper.insert(message);
    }
}
