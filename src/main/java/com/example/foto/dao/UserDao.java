package com.example.foto.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDao {

    private  final static List<UserDetails> APPLICATION_USER = Arrays.asList(
            new User(
                    "kiptoo@gmail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            ),
            new User(
                    "kiptoo",
                    "pass",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            )
    );
    public UserDetails  findUserByEmail(String email){
    return     APPLICATION_USER
                .stream()
                .filter(u->  u.getUsername().equals(email) )
                .findFirst()
                .orElseThrow(()->new UsernameNotFoundException("No USer found"));

    }

}
