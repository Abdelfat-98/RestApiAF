package rest.afproject.api.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.afproject.api.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{

	Boolean existsByName(String name);
	
	Optional<Users> findByName(String name);
}
