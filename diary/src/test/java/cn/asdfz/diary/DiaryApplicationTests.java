package cn.asdfz.diary;

import cn.asdfz.diary.config.Config;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@SpringBootConfiguration
@Import({Config.class})
public class DiaryApplicationTests {
}
