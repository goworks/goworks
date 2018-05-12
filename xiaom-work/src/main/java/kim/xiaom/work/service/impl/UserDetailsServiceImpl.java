package kim.xiaom.work.service.impl;

import kim.xiaom.work.entity.dataObjects.UserDO;
import kim.xiaom.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ge on 12/05/2018.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO userDO = userService.getUserByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        return new User(userDO.getUsername(), userDO.getPassword(), grantedAuthorities);
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
