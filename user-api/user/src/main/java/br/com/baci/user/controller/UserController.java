package br.com.baci.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.baci.user.domain.user.UserDTO;
import br.com.baci.user.service.UserService;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/user")
public class UserController {

    public static List<UserDTO> usuarios = new ArrayList<UserDTO>();

    @Autowired
    private UserService userService;    

    @GetMapping
    public ResponseEntity getUsers(){
        List<UserDTO> users = userService.getAll();        
        return ResponseEntity.ok().body(
            users
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        UserDTO user = userService.findById(id);
        return ResponseEntity.ok().body(user); // https://www.baeldung.com/find-list-element-java
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity getUserById(@PathVariable String cpf){
        UserDTO userDTO = userService.findByCpf(cpf);
        return ResponseEntity.ok().body(userDTO);
        // https://www.baeldung.com/find-list-element-java
        // usuarios.stream()
        //     .filter(user -> cpf.equals(user.getCpf()))
        //     .map(UserDTO::new)
    }
    
    @GetMapping("/user/search")
    public ResponseEntity queryByName(@RequestParam(name="nome", required = true) String nome){
        return ResponseEntity.ok().body(userService.queryByName(nome));
    }

    @PostMapping
    public ResponseEntity newUser(@RequestBody UserDTO userDTO, UriComponentsBuilder UriBuilder){        
        userService.save(userDTO);
        var uri = UriBuilder.path("user/{cpf}").buildAndExpand(userDTO.getCpf()).toUri();
        return ResponseEntity.created(uri).body(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Long id){
        userService.delete(id);            
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