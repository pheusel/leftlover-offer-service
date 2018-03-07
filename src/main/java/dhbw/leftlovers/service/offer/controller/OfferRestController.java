package dhbw.leftlovers.service.offer.controller;

import dhbw.leftlovers.service.offer.entity.Offer;
import dhbw.leftlovers.service.offer.exception.UserNotFoundException;
import dhbw.leftlovers.service.offer.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/{userId}/offers")
class OfferRestController {

    private final OfferRepository offerRepository;

    private final AccountRepository accountRepository;

    // TODO: Zugriff auf Account Repository

    @Autowired
    public OfferRestController(OfferRepository offerRepository, AccountRepository accountRepository) {
        this.offerRepository = offerRepository;
        this.accountRepository = accountRepository;
    }

    // TODO: Anbindung validate Methode aus anderem Service

    @RequestMapping(method = RequestMethod.GET)
    Collection<Offer> readOffers(@PathVariable String userId){
        this.validateUser(userId);
        return this.offerRepository.findByAccountUsername(userId);
    }

    // TODO: Anbindung validate Methode aus anderem Service

    @RequestMapping(method = RequestMethod.GET, value = "/{offerId}")
    Offer readOffer(@PathVariable String userId, @PathVariable Long offerId) {
        this.validateUser(userId);
        return this.offerRepository.findOne(offerId);
    }

    // TODO: Anbindung validate Methode aus anderem Service

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@PathVariable String userId, @RequestBody Offer input){
        this.validateUser(userId);

        return this.accountRepository
                .findByUsername(userId)
                .map(account -> {
                    Offer result = offerRepository.save(new Offer(account,
                            input.getTitel(), input.getDescription(), input.getCreationDate(), input.getCreationTime())));

                    URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest().path("/{id}")
                            .buildAndExpand(result.getId()).toUri();

                    return ResponseEntity.created(location).build();
                })
                .orElse(ResponseEntity.noContent().build());

    }

    // TODO: delete method

    // TODO: validate User in leftlovers-account-service


}
