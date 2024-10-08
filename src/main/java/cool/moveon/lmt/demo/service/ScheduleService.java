package cool.moveon.lmt.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import cool.moveon.lmt.demo.kafka.KafkaProduceService;
import cool.moveon.lmt.demo.mapper.MessageMapper;
import cool.moveon.lmt.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private KafkaProduceService kafkaProduceService;

    @Scheduled(initialDelay = 10000, fixedRate = 5000)
    @Transactional(rollbackFor = RuntimeException.class)
    public void dispatchMessage() {
        Gson gson = new Gson();
        QueryWrapper<Message> wrapper = new QueryWrapper<>();
        wrapper.eq("status", "PENDING");
        List<Message> messageList = messageMapper.selectList(wrapper);
        for (Message message : messageList) {
            kafkaProduceService.sendMessage("order-to-inventory", gson.toJson(message));
            message.setStatus("SENT");
            messageMapper.updateById(message);
        }
    }
}
