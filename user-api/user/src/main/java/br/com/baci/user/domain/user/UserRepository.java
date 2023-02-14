package br.com.baci.user.domain.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByCpf(String cpf);
    List<User> queryByNomeLike(String name);
}