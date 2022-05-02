package rest.afproject.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.afproject.api.dao.UsersRepository;
import rest.afproject.api.entities.Users;

@Service
public class UsersRestService {
    
	@Autowired
	private UsersRepository usersRespo;
	
	public Users save(Users user) {
		return usersRespo.save(user);
	}
	
	public Boolean findUserbyname(String name) {
		return usersRespo.existsByName(name);
	}
	
	public Users userDetails(String name) throws Exception{
		
		return usersRespo.findByName(name)
				.orElseThrow(()-> new Exception("User Not Found"));
		
	}
	
	public List<Users> allUsers(){
		
		return usersRespo.findAll();
		
	}
}
