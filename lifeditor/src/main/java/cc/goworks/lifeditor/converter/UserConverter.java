package cc.goworks.lifeditor.converter;

import cc.goworks.lifeditor.entity.viewObjects.UserVO;
import cc.goworks.lifeditor.tunnel.model.UserDO;
import cc.goworks.lifeditor.utils.CommonUtils;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

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
        userDO.setLogicId(userVO.getId());
        userDO.setUsername(userVO.getUsername());
        userDO.setEmail(userVO.getEmail());
        userDO.setPassword(userVO.getPassword());
        userDO.setMobile(userVO.getMobile());

        if (StringUtils.isEmpty(userDO.getLogicId())) {
            userDO.setLogicId(CommonUtils.uuid());
        }

        return userDO;
    }

    public UserVO convert(UserDO userDO) {
        if (Objects.isNull(userDO)) {
            return null;
        }
        UserVO userVO = new UserVO();
        userVO.setId(userDO.getLogicId());
        userVO.setUsername(userDO.getUsername());
        userVO.setEmail(userDO.getEmail());
        userVO.setPassword(userDO.getPassword());
        userVO.setMobile(userDO.getMobile());

        return userVO;
    }
}
