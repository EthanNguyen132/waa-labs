package edu.miu.waa.lab7.service;

import edu.miu.waa.lab7.model.User;
import edu.miu.waa.lab7.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByEmail(username);
        if (u == null) {
            throw new UsernameNotFoundException(username);
        } else {
            return org.springframework.security.core.userdetails.User
                    .withUsername(u.getEmail())
                    .password(u.getPassword())
                    .authorities(u.getRoles().stream().map(a -> new SimpleGrantedAuthority(a)).toList())
//                    .roles((String[])u.getRoles().toArray())
                    .build();
        }
    }
}
