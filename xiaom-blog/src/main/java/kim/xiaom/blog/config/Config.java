package kim.xiaom.blog.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by wnow20 on 24/12/2017.
 */
@Configuration
@EnableTransactionManagement
@MapperScan(value = "kim.xiaom.blog.dao", sqlSessionFactoryRef = "sqlSessionFactory")
public class Config {
}
