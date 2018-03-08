package dhbw.leftlovers.service.offer.repository;

import dhbw.leftlovers.service.offer.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    Collection<Offer> findByAccountUsername(String username);
}
