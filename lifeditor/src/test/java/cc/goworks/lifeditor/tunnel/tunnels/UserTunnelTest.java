package cc.goworks.lifeditor.tunnel.tunnels;

import cc.goworks.lifeditor.ApplicationTests;
import cc.goworks.lifeditor.tunnel.model.UserDO;
import cc.goworks.lifeditor.utils.TestDataUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static cc.goworks.lifeditor.enums.Active.ACTIVE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApplicationTests.class)
@Transactional
public class UserTunnelTest {
    @Autowired
    private UserTunnel userTunnel;

    @Test
    public void should_create_staff_successfully() {
        UserDO userDO = TestDataUtils.generateUserDO();

        userTunnel.save(userDO);

        UserDO fetched = userTunnel.get(userDO.getLogicId());

        // basic
        assertThat(fetched.getNickname()).isEqualTo(userDO.getNickname());
        assertThat(fetched.getUsername()).isEqualTo(userDO.getUsername());
        assertThat(fetched.getEmail()).isEqualTo(userDO.getEmail());
        assertThat(fetched.getMobile()).isEqualTo(userDO.getMobile());
        assertThat(fetched.getPassword()).isEqualTo(userDO.getPassword());
        assertThat(fetched.getBirthday()).isEqualTo(userDO.getBirthday());
        assertThat(fetched.getGender()).isEqualTo(userDO.getGender());

        // system
        assertThat(fetched.getId()).isNotNull();
        assertThat(fetched.getLogicId()).isNotNull();
        assertThat(fetched.getId()).isEqualTo(userDO.getId());
        assertThat(fetched.getLogicId()).isEqualTo(userDO.getLogicId());
        assertThat(fetched.getStatus()).isEqualTo(userDO.getStatus());
        assertThat(fetched.getGmtCreate()).isNotNull();
        assertThat(fetched.getGmtModify()).isNotNull();
        assertThat(fetched.getCreator()).isEqualTo(userDO.getCreator());
        assertThat(fetched.getModifier()).isEqualTo(userDO.getModifier());
        assertThat(fetched.getVersion()).isEqualTo(1);
        assertThat(fetched.getActive()).isEqualTo(ACTIVE.getValue());
    }

    @Test
    public void should_update_staff_info_successfully() {
        UserDO userDO = TestDataUtils.generateUserDO();
        String originName = userDO.getNickname();
        String originPhone = userDO.getMobile();
        String newMobile = "x" + originPhone.substring(1);
        userTunnel.save(userDO);

        userDO.setNickname(originName + 1);
        userDO.setMobile(newMobile);
        userTunnel.save(userDO);

        UserDO fetched = userTunnel.get(userDO.getLogicId());

        assertThat(fetched).isNotNull();
        assertThat(fetched.getNickname()).isEqualTo(originName + 1);
        assertThat(fetched.getMobile()).isEqualTo(newMobile);
    }

}