package kim.xiaom.work.service.impl;

import kim.xiaom.work.entity.dataObjects.UserDO;
import kim.xiaom.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by ge on 13/05/2018.
 */
@Component
public class AuthenticationServiceImpl implements AuthenticationProvider {
    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        Object credentials = authentication.getCredentials();
        if (!(credentials instanceof String)) {
            return null;
        }
        String password = credentials.toString();

        UserDO userDO = userService.getUserByUsernameAndPassword(username, password);

        if (Objects.isNull(userDO)) {
            throw new BadCredentialsException("Authentication failed for " + username);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE"));
        Authentication auth = new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
