package cool.moveon.lmt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("cool.moveon.lmt.demo.mapper")
@EnableScheduling
public class LocalMessageTableTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocalMessageTableTransactionApplication.class, args);
    }

}
