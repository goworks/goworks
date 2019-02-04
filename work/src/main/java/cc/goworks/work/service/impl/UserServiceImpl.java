package cc.goworks.work.service.impl;

import cc.goworks.work.common.ErrorCode;
import cc.goworks.work.common.RequestException;
import cc.goworks.work.entity.dataObjects.UserDO;
import cc.goworks.work.enums.ActiveEnum;
import cc.goworks.work.enums.UserStatus;
import cc.goworks.work.service.SecurityService;
import cc.goworks.work.service.UserService;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * Created by ge on 12/05/2018.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SecurityService securityService;

    @Override
    public UserDO getUserById(String userId) {
        UserDOExample userDOExample = new UserDOExample();
        userDOExample.createCriteria().andUserIdEqualTo(userId);
        List<UserDO> userDOs = userDOMapper.selectByExample(userDOExample);

        if (CollectionUtils.isEmpty(userDOs)) {
            return null;
        }
        return userDOs.get(0);
    }

    @Override
    public UserDO getUserByUsername(String username) {
        UserDOExample userDOExample = new UserDOExample();
        userDOExample.createCriteria().andUsernameEqualTo(username);
        List<UserDO> userDOs = userDOMapper.selectByExample(userDOExample);

        if (CollectionUtils.isEmpty(userDOs)) {
            return null;
        }
        return userDOs.get(0);
    }

    @Override
    public void createUser(UserDO userDO) {
        userDO.setPassword(bCryptPasswordEncoder.encode(userDO.getPassword()));
        userDO.setVersion(1);
        userDO.setStatus(UserStatus.AVAILABLE.getValue());
        userDO.setActive(ActiveEnum.ACTIVE.getValue());
        userDO.setGmtCreate(new Date());
        userDO.setGmtModify(new Date());

        userDOMapper.insert(userDO);
    }

    @Override
    public void login(UserDO userDO) {
        UserDO fetchedUserDO = this.getUserByUsername(userDO.getUsername());
        if (Objects.isNull(fetchedUserDO)) {
            throw new RequestException(ErrorCode.USER_NOT_EXIST);
        }
        boolean matched = bCryptPasswordEncoder.matches(userDO.getPassword(), fetchedUserDO.getPassword());
        if (!matched) {
            throw new RequestException(ErrorCode.USER_PASSWORD_INCORRECT);
        }
        securityService.autologin(userDO.getUsername(), fetchedUserDO.getPassword());
    }

    @Override
    public void register(UserDO userDO) {
        this.createUser(userDO);
        securityService.autologin(userDO.getUsername(), userDO.getPassword());
    }

    @Override
    public UserDO getUserByUsernameAndPassword(String username, String password) {
        UserDOExample userDOExample = new UserDOExample();
        userDOExample.createCriteria()
                .andUsernameEqualTo(username)
                .andPasswordEqualTo(password);
        List<UserDO> userDOs = userDOMapper.selectByExample(userDOExample);
        if (CollectionUtils.isEmpty(userDOs)) {
            return null;
        }
        return userDOs.get(0);
    }
}
