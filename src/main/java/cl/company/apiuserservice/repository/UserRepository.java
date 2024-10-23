package cl.company.apiuserservice.repository;

import cl.company.apiuserservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
