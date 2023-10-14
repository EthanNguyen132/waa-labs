package edu.miu.waa.lab8.service;

import edu.miu.waa.lab8.dto.RegistrationRequest;
import edu.miu.waa.lab8.model.Role;
import edu.miu.waa.lab8.model.User;
import edu.miu.waa.lab8.model.UserRole;
import edu.miu.waa.lab8.repository.RoleRepository;
import edu.miu.waa.lab8.repository.UserRepository;
import edu.miu.waa.lab8.repository.UserRoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public final UserRoleRepository userRoleRepository;
    public final RoleRepository roleRepository;

    @Override
    @Transactional
    public User save(RegistrationRequest reg) {
        String encryptedPassword = passwordEncoder.encode(reg.getPassword());

        User user = new User();
        user.setEmail(reg.getEmail());
        user.setPassword(encryptedPassword);

        Role role = new Role(reg.getRole());
        roleRepository.save(role);

        UserRole ur = new UserRole(user, role);
        user.addUserRole(ur);
        return userRepository.save(user);

    }

}
