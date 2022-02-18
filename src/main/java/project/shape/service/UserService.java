package project.shape.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.shape.exeption.UserAlreadyExistException;
import project.shape.model.entity.User;
import project.shape.repository.UserRepository;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepo;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepo) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
    }

    public void createUser(String username, String password) throws UserAlreadyExistException {
        if (userRepo.findByUsername(username) != null) {
            //если существует такой юзер
            throw new UserAlreadyExistException(username);
        }

        User newUser = new User(username, passwordEncoder.encode(password));
        userRepo.save(newUser);
    }
}
