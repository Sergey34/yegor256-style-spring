package seko.yegor256.style.spring.user;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Я Объект, я этим горжусь! я личность, но мне обидно, во мне есть ORM
 * эти релейшиншип угнетают меня и я страдаю
 */
public class PersistentUser implements MyUserDetails {
    private final MyUserDetails user;
    private final ObjectId id;
    @Autowired
    @Transient
    private MongoTemplate mongoTemplate;


    public PersistentUser(MyUserDetails user, ObjectId id) {
        this.user = user;
        this.id = id == null ? ObjectId.get() : id;
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

    public String getId() {
        return id.toString();
    }

    public MyUserDetails save() {
        return mongoTemplate.save(this);
    }

    public MyUserDetails get(String id) {
        return mongoTemplate.findById(new ObjectId(id), PersistentUser.class);
    }
}
