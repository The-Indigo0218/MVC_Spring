package indigodev.com.co.mvcprueba.services.impl;

import indigodev.com.co.mvcprueba.exceptions.ResourceNotFoundException;
import indigodev.com.co.mvcprueba.models.User;
import indigodev.com.co.mvcprueba.repositories.UserRepository;
import indigodev.com.co.mvcprueba.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Transactional
    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        repository.deleteById(user.getId());
    }
}
