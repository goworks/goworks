package cc.goworks.work.service.impl;

import cc.goworks.work.service.StaffService;
import cc.goworks.work.tunnel.model.StaffDO;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * Created by ge on 13/05/2018.
 */
@Component
public class AuthenticationServiceImpl implements AuthenticationProvider {
    private StaffService staffService;

    @Autowired
    public AuthenticationServiceImpl(StaffService staffService) {
        this.staffService = staffService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        Object credentials = authentication.getCredentials();
        if (!(credentials instanceof String)) {
            return null;
        }
        String password = credentials.toString();

        StaffDO staffDO = staffService.getUserByUsernameAndPassword(username, password);

        if (Objects.isNull(staffDO)) {
            throw new BadCredentialsException("Authentication failed for " + username);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE"));
        Authentication auth = new UsernamePasswordAuthenticationToken(staffDO, password, grantedAuthorities);
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
