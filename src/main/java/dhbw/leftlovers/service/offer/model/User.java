package dhbw.leftlovers.service.offer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;


    @OneToMany(mappedBy = "account")
    private Set<Offer> offers = new HashSet<>();

    public User(final String username) {
        this.username = username;
    }
}
