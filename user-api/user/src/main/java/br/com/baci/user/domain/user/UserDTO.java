package br.com.baci.user.domain.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO{

    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private Date dataCadastro;

    public UserDTO(UserDTO userDTO){
        this.nome = userDTO.getNome();
        this.cpf = userDTO.getCpf();
        this.endereco = userDTO.getEndereco();
        this.email = userDTO.getEmail();
        this.telefone = userDTO.getTelefone();
        this.dataCadastro = userDTO.getDataCadastro();
    }

    public static UserDTO convert(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setNome(user.getNome());
        userDTO.setEndereco(user.getEndereco());
        userDTO.setCpf(user.getCpf());
        userDTO.setEmail(user.getEmail());
        userDTO.setTelefone(user.getTelefone());
        userDTO.setDataCadastro(user.getDataCadastro());
        return userDTO;
    }

}