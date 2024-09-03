package cool.moveon.lmt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DataSourceConfig
 * @Description TODO
 * @Author Moveon
 * @Date 2024/9/3 18:54
 * @Version 1.0
 **/
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceConfig {
    private String url;
    private String username;
    private String password;
}
