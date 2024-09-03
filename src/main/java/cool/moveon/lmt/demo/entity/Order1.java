package cool.moveon.lmt.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Order1
 * @Description TODO
 * @Author Moveon
 * @Date 2024/9/3 18:21
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order1 {

    private Long id;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 订单描述
     */
    private String orderDesc;
    /**
     * 实付金额
     */
    private String actualAmountPaid;
    /**
     * 订单数量
     */
    private Double quantity;
    /**
     * 付款人员
     */
    private User payUser;
}
