package seko.yegor256.style.spring.user;

import org.springframework.security.core.userdetails.UserDetails;

public interface MyUserDetails extends UserDetails {
    @Override
    default boolean isAccountNonExpired() {
        return false;
    }

    @Override
    default boolean isAccountNonLocked() {
        return false;
    }

    @Override
    default boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    default boolean isEnabled() {
        return false;
    }
}
