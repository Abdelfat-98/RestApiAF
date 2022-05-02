package rest.afproject.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import rest.afproject.api.dto.UserDTO;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	 private Long idUser;
	 
	@Column(nullable = false)
	 private String name;
	
	@Column(nullable = false)
	 private Date birthday;
	
	@Column(nullable = false)
	 private String country;
	 
	 private String phone;
	 
	 private String gender;
	 
	 public Users setUserdto(UserDTO user) {
		 
		 this.name=user.getName();
		 this.birthday=user.getBirthday();
		 this.country=user.getCountry();
		 this.phone=user.getPhone();
		 this.gender=user.getGender();
		 
		 return this;
		 
	 }
	
}
