package dhbw.leftlovers.service.offer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Offer {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne
    private User user;

    private String titel;

    private String description;

    private LocalDateTime creationTimestamp;

    // TODO: Add Image

    public Offer(User user, String titel, String description, LocalDateTime creationTimestamp) {
        this.user = user;
        this.titel = titel;
        this.description = description;
        this.creationTimestamp = creationTimestamp;
    }
}

