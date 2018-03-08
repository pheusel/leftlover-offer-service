package dhbw.leftlovers.service.offer.service;

import dhbw.leftlovers.service.offer.model.Offer;
import dhbw.leftlovers.service.offer.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public Offer findOne(Long offerId) {
        return offerRepository.findOne(offerId);
    }

    @Override
    public Collection<Offer> findByAccountUsername(String username) {
        return offerRepository.findByAccountUsername(username);
    }

    @Override
    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }
}
