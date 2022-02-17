package project.shape.service;

import org.springframework.stereotype.Service;
import project.shape.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
}
