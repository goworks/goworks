package kim.xiaom.work.converter;

import kim.xiaom.work.entity.dataObjects.UserDO;
import kim.xiaom.work.entity.viewObjects.UserVO;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ge on 13/05/2018.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class UserConverterUnitTest {
    private UserConverter userConverter;

    @Before
    public void setup() {
        userConverter = new UserConverter();
    }

    @Test
    public void should_convert_to_userDO_successful() {
        UserVO userVO = new UserVO();
        String username = "test_123";
        String password = "123_test";
        String phone = "17000000000";
        userVO.setUsername(username);
        userVO.setPassword(password);
        userVO.setPhone(phone);

        UserDO userDO = userConverter.convert(userVO);
        assertThat(userDO).isNotNull();
        assertThat(userDO.getUserId()).isNotNull();
        assertThat(userDO.getUserId().length()).isEqualTo(36);
        assertThat(userDO.getUsername()).isEqualTo(username);
        assertThat(userDO.getPassword()).isEqualTo(password);
        assertThat(userDO.getPhone()).isEqualTo(phone);
    }
}
