package rest.afproject.api.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class UserDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	private Long idUser;
	private String name;
	private Date birthday;
	private String country;
	private String phone;
	private String gender;
	
	
	
	
}
