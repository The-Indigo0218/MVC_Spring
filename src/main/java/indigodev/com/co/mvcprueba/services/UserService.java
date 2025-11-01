package indigodev.com.co.mvcprueba.services;

import indigodev.com.co.mvcprueba.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(long id);
    User save(User user);
    void delete(User user);

}
