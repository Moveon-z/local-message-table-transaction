package cool.moveon.lmt.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("biz_product")
public class Product {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 剩余库存
     */
    private Integer surplusQuantity;

    private Timestamp createTime;

    private Timestamp updateTime;
}
