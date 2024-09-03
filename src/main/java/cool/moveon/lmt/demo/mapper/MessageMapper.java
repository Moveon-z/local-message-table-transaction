package cool.moveon.lmt.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.moveon.lmt.model.Message;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName MessageMapper
 * @Description TODO
 * @Author Moveon
 * @Date 2024/9/3 22:42
 * @Version 1.0
 **/
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

}
