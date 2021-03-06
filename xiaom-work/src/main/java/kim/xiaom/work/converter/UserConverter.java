package kim.xiaom.work.converter;

import kim.xiaom.work.entity.dataObjects.UserDO;
import kim.xiaom.work.entity.viewObjects.UserVO;
import kim.xiaom.work.utils.XiaomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

/**
 * Created by ge on 12/05/2018.
 */
@Component
public class UserConverter {
    public UserDO convert(UserVO userVO) {
        if (Objects.isNull(userVO)) {
            return null;
        }
        UserDO userDO = new UserDO();
        userDO.setUserId(userVO.getId());
        userDO.setUsername(userVO.getUsername());
        userDO.setEmail(userVO.getEmail());
        userDO.setPassword(userVO.getPassword());
        userDO.setPhone(userVO.getPhone());

        if (StringUtils.isEmpty(userDO.getUserId())) {
            userDO.setUserId(XiaomUtils.uuid());
        }

        return userDO;
    }

    public UserVO convert(UserDO userDO) {
        if (Objects.isNull(userDO)) {
            return null;
        }
        UserVO userVO = new UserVO();
        userVO.setId(userDO.getUserId());
        userVO.setUsername(userDO.getUsername());
        userVO.setEmail(userDO.getEmail());
        userVO.setPassword(userDO.getPassword());
        userVO.setPhone(userDO.getPhone());

        return userVO;
    }
}
