package cc.goworks.lifeditor.utils;

import cc.goworks.lifeditor.enums.Gender;
import cc.goworks.lifeditor.enums.UserStatus;
import cc.goworks.lifeditor.tunnel.model.UserDO;

import static java.time.LocalDateTime.parse;

/**
 * Created by ge on 12/05/2018.
 */
public class TestDataUtils {
    public static UserDO generateUserDO() {
        UserDO userDO = new UserDO();
        userDO.setLogicId(CommonUtils.uuid());
        userDO.setUsername("testUsername");
        userDO.setPassword("password");
        userDO.setNickname("nickname");
        userDO.setGender(Gender.FEMALE.getValue());
        userDO.setMobile("18800001234");
        userDO.setEmail("test@example.com");
        userDO.setStatus(UserStatus.AVAILABLE.getValue());
        userDO.setCreator("creator");
        userDO.setModifier("modifier");
        return userDO;
    }
}
