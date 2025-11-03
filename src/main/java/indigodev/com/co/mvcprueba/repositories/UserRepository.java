package indigodev.com.co.mvcprueba.repositories;

import indigodev.com.co.mvcprueba.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
