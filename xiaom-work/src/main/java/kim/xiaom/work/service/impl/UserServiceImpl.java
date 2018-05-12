package kim.xiaom.work.service.impl;

import kim.xiaom.work.common.ErrorCode;
import kim.xiaom.work.common.RequestException;
import kim.xiaom.work.dao.UserDOMapper;
import kim.xiaom.work.entity.dataObjects.UserDO;
import kim.xiaom.work.entity.queryObjects.UserDOExample;
import kim.xiaom.work.enums.ActiveEnum;
import kim.xiaom.work.enums.UserStatus;
import kim.xiaom.work.service.SecurityService;
import kim.xiaom.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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
        String loginPassword = bCryptPasswordEncoder.encode(userDO.getPassword());
        if (!loginPassword.equals(fetchedUserDO.getPassword())) {
            throw new RequestException(ErrorCode.USER_PASSWORD_INCORRECT);
        }
        securityService.autologin(userDO.getUsername(), userDO.getPassword());
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
