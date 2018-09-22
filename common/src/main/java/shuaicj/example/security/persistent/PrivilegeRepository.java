package shuaicj.example.security.persistent;

import org.springframework.data.jpa.repository.JpaRepository;

import shuaicj.example.security.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
	 
	Privilege findByName(String name);
}
