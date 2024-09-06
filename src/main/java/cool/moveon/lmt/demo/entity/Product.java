package cool.moveon.lmt.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 价格
     */
    private BigDecimal price;

    private Integer surplusQuantity;

    private Timestamp createTime;

    private Timestamp updateTime;
}
