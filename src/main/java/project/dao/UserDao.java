package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.User;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {
    User findByName(String name);

}
