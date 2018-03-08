package dhbw.leftlovers.service.offer.service;

import dhbw.leftlovers.service.offer.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);

}
