package com.projet.quizizback.app.ejemplocruduser.services;

import com.projet.quizizback.app.ejemplocruduser.entity.UserEntity;
import com.projet.quizizback.app.ejemplocruduser.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServices {
    /*@Autowired
    private Userrepository userrepository;*/

    private final Userrepository userRepository;

    public UserServices(Userrepository userRepository) {
        this.userRepository = userRepository;
    }

    /*public List<UserEntity> getAll() {
        return userRepository.findAll(); // select * from USER
    }*/

    public List<UserEntity> getById(String id) { // Map<UserEntity, String>  listar - buscar
        if(id != null) {
            List<UserEntity> unicoUser = new ArrayList<>();
            unicoUser.add(userRepository.findById(id).orElse(null));
            return unicoUser;
        }
        return userRepository.findAll(); // select * from USER
    }

    public String deleteUser(String ident) {
        // primero validamos si el id existe
        UserEntity userEncorado = userRepository.getReferenceById(ident);
        if(userEncorado != null) {
            userRepository.deleteById(ident);
            return "Usuario eliminado con éxito";
        } else {
            return "Usuario no encontrado";
        }
    }

    // editar y guardar

    public UserEntity saveUser(UserEntity user) {
        List<UserEntity> entities = getById(user.getIdent());
        if (entities.get(0) == null) {
            return userRepository.save(user);
        } else {
            entities.get(0).setUserName(user.getUserName());
            entities.get(0).setEmail(user.getEmail());
            entities.get(0).setPassword(user.getPassword());

            return userRepository.save(entities.get(0));
        }
    }
}
