package ru.cyberherbs.cactus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.cyberherbs.cactus.Models.Role;
import ru.cyberherbs.cactus.Models.User;
import ru.cyberherbs.cactus.backend.DB.RoleRepository;
import ru.cyberherbs.cactus.backend.DB.UserRepository;

import java.util.Collections;
import java.util.HashSet;

@Service("userService")
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder encoder;
@Autowired
    public UserService(UserRepository userRepository, @Qualifier("roleRepository") RoleRepository roleRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    public User findUserByEmail(String email){
        return userRepository.findAllByEmail(email);
    }

    public void saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
        userRepository.save(user);
    }
}
