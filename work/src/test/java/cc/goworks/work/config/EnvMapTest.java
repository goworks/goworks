package cc.goworks.work.config;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EnvMapTest {
    @Test
    public void should_get_env_value_by_key_successfully() {
        String javaHome = EnvMap.getByKey("JAVA_HOME");
        Assertions.assertThat(javaHome).isNotEmpty();
    }
}
