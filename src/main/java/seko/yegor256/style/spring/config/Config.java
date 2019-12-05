package seko.yegor256.style.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import seko.yegor256.style.spring.user.EmailUser;
import seko.yegor256.style.spring.user.PersistentUser;
import seko.yegor256.style.spring.user.User;

import java.util.Collections;

/**
 * я не объект, я не личность, я ужас на крыльях современного процедурного программирования
 * у меня нет ничего, со мной неприятно работать
 * я лишь набор аспекотов
 * хотя имя хорошее, правильное
 */
@Configuration
public class Config {
    @Bean("p_user")
    public PersistentUser myUserDetails() {
        final SimpleGrantedAuthority decorator_evangelist_role = new SimpleGrantedAuthority("decorator_evangelist_role");
        final User yegor = new User("Yegor", "256", Collections.singletonList(decorator_evangelist_role));
        return new PersistentUser(new EmailUser(yegor, "yegor256@rambler.com"), null);
    }
}
