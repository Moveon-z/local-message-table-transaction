package cool.moveon.lmt.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @ClassName Message
 * @Description TODO
 * @Author Moveon
 * @Date 2024/9/3 19:50
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("local_message_table")
public class Message {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 业务数据id
     */
    private Long objId;
    /**
     * 状态
     * PENDING: 消息已创建并存储在消息表中，但还未发送到mq中
     * SENT: 消息已成功发送到mq中
     * FAILED: 消息发送到mq失败
     * PROCESSING: 消息正在发送过程中
     * ACKNOWLEDGED: 消息已确认
     */
    private String status;
    /**
     * 消息体
     */
    private String messageBody;
    /**
     * 反馈操作
     * RETRY: 重试
     * CALLBACK: 回滚
     */
    private String operation;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 修改时间
     */
    private Timestamp updateTime;
}
