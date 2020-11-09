package ru.kpfu.itis.group903.nurkaev.services;

import ru.kpfu.itis.group903.nurkaev.exceptions.DuplicateEntryException;
import ru.kpfu.itis.group903.nurkaev.exceptions.WrongEmailOrPasswordException;
import ru.kpfu.itis.group903.nurkaev.forms.LoginForm;
import ru.kpfu.itis.group903.nurkaev.forms.UserForm;
import ru.kpfu.itis.group903.nurkaev.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    void save(User entity);
    void delete(User entity);
    void deleteByEmail(String email);
    void update(User entity);
    void updateByEmail(String firstName, String lastName, String email);
    List<User> getAllUsers();
    Optional<User> findById(Long id);
    Optional<User> findOneByEmail(String email);

    void signUp(UserForm userForm) throws DuplicateEntryException;
    void signIn(LoginForm loginForm) throws WrongEmailOrPasswordException;
}
