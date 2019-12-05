package seko.yegor256.style.spring.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class RestUser implements MyUserDetails {
    private final PersistentUser user;

    public RestUser(@Qualifier("p_user") PersistentUser user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @GetMapping(path = {"/", "/{id}"})
    public MyUserDetails getUserInfo(@PathVariable(required = false) String id) {
        return user.get(id);
    }

    @GetMapping("/_save_default")
    public MyUserDetails saveUserInfo() {
        return user.save();
    }

}
