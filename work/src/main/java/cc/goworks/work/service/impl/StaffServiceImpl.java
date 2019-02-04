package cc.goworks.work.service.impl;

import cc.goworks.work.common.ErrorCode;
import cc.goworks.work.common.RequestException;
import cc.goworks.work.enums.UserStatus;
import cc.goworks.work.service.SecurityService;
import cc.goworks.work.service.StaffService;
import cc.goworks.work.tunnel.model.StaffDO;
import cc.goworks.work.tunnel.tunnels.StaffTunnel;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    private StaffTunnel staffTunnel;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private SecurityService securityService;

    @Autowired
    public StaffServiceImpl(StaffTunnel tunnel,
                            BCryptPasswordEncoder passwordEncoder,
                            SecurityService securityService) {
        staffTunnel = tunnel;
        bCryptPasswordEncoder = passwordEncoder;
        this.securityService = securityService;
    }

    @Override
    public StaffDO getById(String staffId) {
        return staffTunnel.get(staffId);
    }

    @Override
    public StaffDO getByUsername(String username) {
        return staffTunnel.getByUsername(username);
    }

    @Override
    public void createUser(StaffDO staffDO) {
        staffDO.setPassword(bCryptPasswordEncoder.encode(staffDO.getPassword()));
        staffDO.setStatus(UserStatus.AVAILABLE.getValue());

        staffTunnel.save(staffDO);
    }

    @Override
    public void login(StaffDO staffDO) {
        StaffDO fetchedStaffDO = this.getByUsername(staffDO.getUsername());
        if (Objects.isNull(fetchedStaffDO)) {
            throw new RequestException(ErrorCode.USER_NOT_EXIST);
        }
        boolean matched = bCryptPasswordEncoder.matches(staffDO.getPassword(), fetchedStaffDO.getPassword());
        if (!matched) {
            throw new RequestException(ErrorCode.USER_PASSWORD_INCORRECT);
        }
        securityService.autologin(staffDO.getUsername(), fetchedStaffDO.getPassword());
    }

    @Override
    public StaffDO getUserByUsernameAndPassword(String username, String password) {
        return staffTunnel.getUserByUsernameAndPassword(username, password);
    }
}
