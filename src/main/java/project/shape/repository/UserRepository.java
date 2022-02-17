package project.shape.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.shape.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
