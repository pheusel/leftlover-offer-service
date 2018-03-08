package dhbw.leftlovers.service.offer.service;

import dhbw.leftlovers.service.offer.model.Offer;

import java.util.Collection;

public interface OfferService {

    Offer findOne(Long offerId);

    Collection<Offer> findByAccountUsername(String username);

    Offer save(Offer offer);
}
