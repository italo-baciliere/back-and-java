package br.com.baci.user.domain.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    User findByCpf(String cpf);

    List<User> queryByNameLike(String name);
}