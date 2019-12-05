package seko.yegor256.style.spring.user;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Я юзер с мылом. я личность! я Декоратор
 * все поля финальные
 * полей мало
 * сетеров нет
 * метод смены мыл нащывается правильно, возвращает новый объект
 */
public class EmailUser implements MyUserDetails {
    private final MyUserDetails user;
    private final String email;

    public EmailUser(MyUserDetails user, String email) {
        this.user = user;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public EmailUser changeEmail(String email) {
        return new EmailUser(this.user, email);
    }
}
