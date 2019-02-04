package cc.goworks.work;

import cc.goworks.work.config.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootApplication
@SpringBootConfiguration
@Import({Config.class})
public class WorkApplicationTests {

	@Test
	public void contextLoads() {
	}

}

