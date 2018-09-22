package shuaicj.example.security.persistent;

import org.springframework.data.jpa.repository.JpaRepository;

import shuaicj.example.security.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	 
    User findByUsername(String username);
}
