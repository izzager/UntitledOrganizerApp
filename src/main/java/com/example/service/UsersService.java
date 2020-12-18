package com.example.service;

import com.example.entity.User;
import com.example.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements UserDetailsService {
    @Autowired
    public UsersRepository usersRepository;

    public UsersService() {}

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = usersRepository.findByUsername(s);
        System.out.println("try to sign in");
        if (user.isEmpty()) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println(user.toString());
        System.out.println(bCryptPasswordEncoder.encode(user.get().getPassword()));
        return user.get();
    }

    public boolean save(User user) {
        if (usersRepository.findByUsername(user.getUsername()).isPresent()) {
            return false;
        }
        usersRepository.save(user);
        System.out.println("save " + user);
        return true;
    }
}
