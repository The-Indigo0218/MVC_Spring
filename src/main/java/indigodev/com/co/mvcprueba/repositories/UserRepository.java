package indigodev.com.co.mvcprueba.repositories;

import indigodev.com.co.mvcprueba.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
}
