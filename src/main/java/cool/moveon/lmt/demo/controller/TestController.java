package cool.moveon.lmt.demo.controller;

import com.google.gson.Gson;
import cool.moveon.lmt.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author Moveon
 * @Date 2024/9/3 22:54
 * @Version 1.0
 **/
@RestController
public class TestController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/createOrder")
    public String createOrder() {
        orderService.createOrder();
        return "";
    }
}
