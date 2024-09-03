package cool.moveon.lmt.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.moveon.lmt.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName OrderMapper
 * @Description TODO
 * @Author Moveon
 * @Date 2024/9/3 20:58
 * @Version 1.0
 **/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
