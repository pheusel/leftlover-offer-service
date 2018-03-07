package dhbw.leftlovers.service.offer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@NoArgsConstructor
public class Offer {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Account account;

    private String titel;

    private String description;

    private Date creationDate;

    private Time creationTime;

    // TODO: Add Image

    public Offer(Account account, String titel, String description, Date creationDate, Time creationTime) {
        this.account = account;
        this.titel = titel;
        this.description = description;
        this.creationDate = creationDate;
        this.creationTime = creationTime;
    }
}

