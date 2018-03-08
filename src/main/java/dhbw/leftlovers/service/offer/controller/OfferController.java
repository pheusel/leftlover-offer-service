package dhbw.leftlovers.service.offer.controller;

import dhbw.leftlovers.service.offer.model.Offer;
import dhbw.leftlovers.service.offer.exception.UserNotFoundException;
import dhbw.leftlovers.service.offer.service.OfferService;
import dhbw.leftlovers.service.offer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/{userId}/offers")
class OfferController {

    @Autowired
    private OfferService offerService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    Collection<Offer> readOffers(@PathVariable String userId) {
        this.validateUser(userId);
        return this.offerService.findByAccountUsername(userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{offerId}")
    Offer readOffer(@PathVariable String userId, @PathVariable Long offerId) {
        this.validateUser(userId);
        return this.offerService.findOne(offerId);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@PathVariable String userId, @RequestBody Offer input) {
        this.validateUser(userId);

        return this.userService
                .findByUsername(userId)
                .map(account -> {
                    Offer result = offerService.save(new Offer(account, input.getTitel(), input.getDescription(), input.getCreationTimestamp()));

                    URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest().path("/{id}")
                            .buildAndExpand(result.getId()).toUri();

                    return ResponseEntity.created(location).build();
                })
                .orElse(ResponseEntity.noContent().build());
    }

    private void validateUser(String userId) {

        this.userService.findByUsername(userId).orElseThrow(
                () -> new UserNotFoundException(userId));

    }
}
