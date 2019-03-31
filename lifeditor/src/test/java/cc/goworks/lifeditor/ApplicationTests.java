package cc.goworks.lifeditor;

import cc.goworks.lifeditor.config.Config;
import org.junit.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@SpringBootConfiguration
@Import({Config.class})
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

}

