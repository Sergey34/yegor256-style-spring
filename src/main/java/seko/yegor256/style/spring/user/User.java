package seko.yegor256.style.spring.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Я Объект Юзер, Я личность. Юзер - это звучит гордо!
 * полей всего 3
 * поля финальные
 * есть интерфейс (контракт) которому я соответствую
 */
public class User implements MyUserDetails {
    private final String username;
    private final String password;
    private final Collection<GrantedAuthority> authorities;

    public User(String username, String password, Collection<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
