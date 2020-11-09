package ru.kpfu.itis.group903.nurkaev.services;

import ru.kpfu.itis.group903.nurkaev.exceptions.DuplicateEntryException;
import ru.kpfu.itis.group903.nurkaev.exceptions.WrongEmailOrPasswordException;
import ru.kpfu.itis.group903.nurkaev.forms.LoginForm;
import ru.kpfu.itis.group903.nurkaev.forms.UserForm;
import ru.kpfu.itis.group903.nurkaev.models.User;
import ru.kpfu.itis.group903.nurkaev.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem1
 */

public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void save(User entity) {
        usersRepository.save(entity);
    }

    @Override
    public void delete(User entity) {
        usersRepository.delete(entity);
    }

    @Override
    public void deleteByEmail(String email) {
        usersRepository.deleteByEmail(email);
    }

    @Override
    public void update(User entity) {
        usersRepository.update(entity);
    }

    @Override
    public void updateByEmail(String firstName, String lastName, String email) {
        usersRepository.updateByEmail(firstName, lastName, email);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Optional<User> findOneByEmail(String email) {
        return usersRepository.findOneByEmail(email);
    }

    @Override
    public void signUp(UserForm userForm) throws DuplicateEntryException {
        usersRepository.signUp(userForm);
    }

    @Override
    public void signIn(LoginForm loginForm) throws WrongEmailOrPasswordException {
        usersRepository.signIn(loginForm);
    }
}
