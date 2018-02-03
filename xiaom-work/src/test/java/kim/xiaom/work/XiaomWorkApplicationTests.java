package kim.xiaom.work;

import kim.xiaom.work.config.Config;
import org.junit.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@SpringBootConfiguration
@Import({Config.class})
public class XiaomWorkApplicationTests {

	@Test
	public void contextLoads() {
	}
}
