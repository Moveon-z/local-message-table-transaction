package cool.moveon.lmt.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.moveon.lmt.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName ProductMapper
 * @Description TODO
 * @Author huangzh
 * @Date 2024/9/6 15:59
 * @Version 1.0
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
