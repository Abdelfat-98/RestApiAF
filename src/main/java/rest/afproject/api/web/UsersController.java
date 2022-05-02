package rest.afproject.api.web;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import rest.afproject.api.date.Formatdate;
import rest.afproject.api.dto.UserDTO;
import rest.afproject.api.entities.Users;
import rest.afproject.api.services.UsersRestService;

@Slf4j
@RestController
@RequestMapping(value="/api/users")
public class UsersController {
    
	@Autowired
	private
	UsersRestService userService;
	
	@PostMapping(value = "/create")
	public ResponseEntity<Object> create(@RequestBody UserDTO user) {
		//Testing if user not exit 
		if(Boolean.FALSE.equals(userService.findUserbyname(user.getName()))) {
			      //Testing if required fields are not empty
			      if(user.getName().isEmpty() || user.getBirthday().toString().isEmpty() || user.getCountry().isEmpty()){
			    	  log.info("Create Merthod : Check that required fileds are not empty");
				      return  new ResponseEntity<>("Please verify if required fields are not empty",HttpStatus.BAD_REQUEST);
				  //Testing if user is adult and French resident
			      }else if(!user.getCountry().equals("French") || ((java.time.Year.now().getValue()-Formatdate.getYear(user.getBirthday()))<18)) {
			    	   log.info("Create Merthod : Check Country and age for " + user.getName()+ " only adult French residents are allowed to create an account");
				       return  new ResponseEntity<>("Only adult French residents are allowed to create an account",HttpStatus.BAD_REQUEST);
			      //if all is ok user will be created
			      }else {
			    	    log.info("Create Merthod : User " + user.getName() + " Created succefuly");
			            Users usertosave = new Users();
			            return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(usertosave.setUserdto(user)));
			}
		//If user exist creation will field 	      
		}else {
			log.info("Create Merthod : User " + user.getName() + " already exist in database");
			return  new ResponseEntity<>("User already exist in database",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping(value="/finduser/{name}")
	public ResponseEntity<Object> userDetails(@PathVariable(value="name") String name) throws Exception{
		/*
		 *if(Boolean.TRUE.equals(userService.findUserbyname(name))){ return
		 * ResponseEntity.status(HttpStatus.OK).body(userService.userDetails(name));
		 * }else return new ResponseEntity<>("User not exist",HttpStatus.NOT_FOUND);
		 */
		return	ResponseEntity.status(HttpStatus.OK).body(userService.userDetails(name));
	}
	
	@GetMapping(value="/allusers")
	public ResponseEntity<List<Users>> getAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(userService.allUsers());
	}
}
