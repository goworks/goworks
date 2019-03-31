package cc.goworks.lifeditor.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by wnow20 on 24/12/2017.
 */
@Configuration
@EnableTransactionManagement
@MapperScan(value = "cc.goworks.work", sqlSessionFactoryRef = "sqlSessionFactory")
public class Config {
}
