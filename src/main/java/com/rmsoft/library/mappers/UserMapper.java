package com.rmsoft.library.mappers;

import com.rmsoft.library.domain.User;

import java.util.Optional;

public interface UserMapper {

  void insertUser(User user);

  Optional<User> findByEmail(String email);

}
