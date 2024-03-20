package com.bankglsistem.bankglsistem.services;

import com.bankglsistem.bankglsistem.domain.user.User;
import com.bankglsistem.bankglsistem.domain.user.UserType;
import com.bankglsistem.bankglsistem.dtos.UserDTO;
import com.bankglsistem.bankglsistem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuario do tipo Lojista não está autorizado a realizar transações ");
        }

        if(sender.getBalance().compareTo(amount) <0){
            throw new Exception("Saldo insuficiente");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }

    public void saveUser(User user){
        this.repository.save(user);
    }

}