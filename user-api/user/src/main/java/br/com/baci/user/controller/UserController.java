package br.com.baci.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.baci.user.domain.user.UserDTO;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/users")
public class UserController {

    public static List<UserDTO> usuarios = new ArrayList<UserDTO>();

    @GetMapping
    public ResponseEntity getMensagem(){        
        return ResponseEntity.ok().body("Spring boot is working!!");
    }


    @GetMapping("/all-users")
    public ResponseEntity getAllUsers(@PathVariable String cpf){
        return ResponseEntity.ok().body(
            usuarios
        );
    }


    @GetMapping("/{cpf}")
    public ResponseEntity getUserById(@PathVariable String cpf){
        return ResponseEntity.ok().body(
            usuarios.stream()
            .filter(user -> cpf.equals(user.getCpf()))            
            .map(UserDTO::new)
        ); // https://www.baeldung.com/find-list-element-java
    }    


    @PostMapping("/newUser")    
    public ResponseEntity inserir(@RequestBody UserDTO userDto, UriComponentsBuilder UriBuilder){
        UserDTO novoUsuario = userDto;
        novoUsuario.setDataCadastro(new Date());
        usuarios.add(userDto);
        var uri = UriBuilder.path("users/{cpf}").buildAndExpand(novoUsuario.getCpf()).toUri();
        return ResponseEntity.created(uri).body(novoUsuario);
    }


    @DeleteMapping("/{cpf}")
    public ResponseEntity remover(@PathVariable String cpf){
        // usuarios.stream()
        //     .filter(user -> cpf.equals(user.getCpf()));
        for (UserDTO userFilter: usuarios) {
            if (userFilter.getCpf().equals(cpf)) {
                usuarios.remove(userFilter);
                ResponseEntity.noContent().build();
            }
        }
        // return false;
        return ResponseEntity.noContent().build();
    }


    @PostConstruct
    public void initiateList(){
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Eduardo");
        userDTO.setCpf("123");
        userDTO.setEndereco("Rua a");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setTelefone("1234-3454");
        userDTO.setDataCadastro(new Date());
        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Luiz");
        userDTO2.setCpf("456");
        userDTO2.setEndereco("Rua b");
        userDTO2.setEmail("luiz@email.com");
        userDTO2.setTelefone("1234-3454");
        userDTO2.setDataCadastro(new Date());
        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("Bruna");
        userDTO3.setCpf("678");
        userDTO3.setEndereco("Rua c");
        userDTO3.setEmail("bruna@email.com");
        userDTO3.setTelefone("1234-3454");

        userDTO3.setDataCadastro(new Date());
        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);
    }    

}