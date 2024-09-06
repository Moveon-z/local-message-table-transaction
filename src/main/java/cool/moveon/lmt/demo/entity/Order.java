package cool.moveon.lmt.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @ClassName Order
 * @Description TODO
 * @Author Moveon
 * @Date 2024/9/3 21:09
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("biz_order")
public class Order {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 购买人id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 总金额
     */
    private BigDecimal amount;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 订单状态
     * CREATED: 已创建
     * SENT: 已发送
     * CANCELLATION: 作废
     * PAID: 已支付
     * SUCCESS: 订单完成
     */
    private String status;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

}
