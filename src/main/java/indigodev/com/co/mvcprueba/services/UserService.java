package indigodev.com.co.mvcprueba.services;

import indigodev.com.co.mvcprueba.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(long id);
    User save(User user);
    void delete(User user);

}
