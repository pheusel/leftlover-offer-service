package dhbw.leftlovers.service.offer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "account")
    private Set<Offer> offers = new HashSet<>();

    public Account(final String username, final String password) {
        this.username = username;
        this.password = password;
    }
}
