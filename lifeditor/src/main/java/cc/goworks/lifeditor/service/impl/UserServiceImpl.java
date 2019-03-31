package cc.goworks.lifeditor.service.impl;

import cc.goworks.lifeditor.common.ErrorCode;
import cc.goworks.lifeditor.common.RequestException;
import cc.goworks.lifeditor.enums.UserStatus;
import cc.goworks.lifeditor.service.SecurityService;
import cc.goworks.lifeditor.service.UserService;
import cc.goworks.lifeditor.tunnel.model.UserDO;
import cc.goworks.lifeditor.tunnel.tunnels.UserTunnel;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserTunnel userTunnel;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private SecurityService securityService;

    @Autowired
    public UserServiceImpl(UserTunnel tunnel,
                            BCryptPasswordEncoder passwordEncoder,
                            SecurityService securityService) {
        userTunnel = tunnel;
        bCryptPasswordEncoder = passwordEncoder;
        this.securityService = securityService;
    }

    @Override
    public UserDO getById(String staffId) {
        return userTunnel.get(staffId);
    }

    @Override
    public UserDO getByUsername(String username) {
        return userTunnel.getByUsername(username);
    }

    @Override
    public void createUser(UserDO staffDO) {
        staffDO.setPassword(bCryptPasswordEncoder.encode(staffDO.getPassword()));
        staffDO.setStatus(UserStatus.AVAILABLE.getValue());

        userTunnel.save(staffDO);
    }

    @Override
    public void login(UserDO staffDO) {
        UserDO fetchedUserDO = this.getByUsername(staffDO.getUsername());
        if (Objects.isNull(fetchedUserDO)) {
            throw new RequestException(ErrorCode.USER_NOT_EXIST);
        }
        boolean matched = bCryptPasswordEncoder.matches(staffDO.getPassword(), fetchedUserDO.getPassword());
        if (!matched) {
            throw new RequestException(ErrorCode.USER_PASSWORD_INCORRECT);
        }
        securityService.autologin(staffDO.getUsername(), fetchedUserDO.getPassword());
    }

    @Override
    public UserDO getUserByUsernameAndPassword(String username, String password) {
        return userTunnel.getUserByUsernameAndPassword(username, password);
    }
}
