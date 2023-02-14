package br.com.baci.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.baci.user.domain.user.User;
import br.com.baci.user.domain.user.UserDTO;
import br.com.baci.user.domain.user.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll(){
        List<User> usuarios = userRepository.findAll();
        return usuarios.stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());        
    }
    
    public UserDTO findById(Long id){
        Optional<User> user = userRepository.findById(id);
        
        if(user.isPresent())
            return UserDTO.convert(user.get());
        return null;
    }

    public UserDTO save(UserDTO userDTO){
        User user = userRepository.save(User.convert(userDTO));        
        return UserDTO.convert(user);
    }

    public UserDTO delete(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
            userRepository.delete(user.get());
        return null;
    }

    public UserDTO findByCpf(String cpf){        
        User user = userRepository.findByCpf(cpf);
        if(user != null){
            return UserDTO.convert(user);
        }        
        return null;
    }

    public List<UserDTO> queryByName(String nome){
        List<User> usuarios = userRepository.queryByNomeLike(nome);
        return usuarios.stream()
                       .map(UserDTO::convert)
                       .collect(Collectors.toList());
    }
}