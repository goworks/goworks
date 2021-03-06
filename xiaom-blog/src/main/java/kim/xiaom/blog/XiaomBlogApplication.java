package kim.xiaom.blog;

import kim.xiaom.blog.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@SpringBootConfiguration
@Import({Config.class})
@EnableWebMvc
public class XiaomBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(XiaomBlogApplication.class, args);
	}
}
