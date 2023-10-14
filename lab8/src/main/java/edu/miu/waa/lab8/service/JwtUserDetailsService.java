package edu.miu.waa.lab8.service;

import edu.miu.waa.lab8.model.User;
import edu.miu.waa.lab8.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User u = userRepository.findByEmail(username);
//        if (u == null) {
//            throw new UsernameNotFoundException(username);
//        } else {
//            return org.springframework.security.core.userdetails.User
//                    .withUsername(u.getEmail())
//                    .password(u.getPassword())
//                    .authorities(u.getUserRoles().stream().map(ur -> new SimpleGrantedAuthority(ur.getRole().getName())).toList())
////                    .roles((String[])u.getRoles().toArray())
//                    .build();
//        }

        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " Not Found"));
    }
}
