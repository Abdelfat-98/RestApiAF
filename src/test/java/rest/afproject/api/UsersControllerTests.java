package rest.afproject.api;



import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import rest.afproject.api.date.Formatdate;
import rest.afproject.api.entities.Users;
import rest.afproject.api.services.UsersRestService;
import rest.afproject.api.web.UsersController;



@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = UsersController.class)
class UsersControllerTests {
	


    @Autowired
    private MockMvc mockMvc;
	

	
    @MockBean
    private UsersRestService usersserv;
    
    
	 
    private Users user=new Users(1L,"FARID",Formatdate.parseDate("2000-11-01"),"French","0628466847","Male");
    



	
	
		
      
        
        	 
       
		
		
		  @Test void getUserTestFct() throws Exception{
		  Mockito.when(usersserv.userDetails(Mockito.anyString())).thenReturn(user);
		  
		  RequestBuilder requestBuilder = MockMvcRequestBuilders
		  .get("/api/users/finduser/FARID").accept(MediaType.APPLICATION_JSON);
		  
		  MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		  
		  System.out.println(result.getResponse());
		  
		  String expected =
		  "{\"idUser\":1,\"name\":\"FARID\",\"birthday\":\"2000-11-01T00:00:00.000+00:00\",\"country\":\"French\",\"phone\":\"0628466847\",\"gender\":\"Male\"}";
		  
		  System.out.println("this is yur string" +
		  result.getResponse().getContentAsString());
		  
		  JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),
		  false); }
		 
		 
	
		
		
		  @Test void createUserTestFct() throws Exception{
		  Mockito.when(usersserv.save(Mockito.any(Users.class))).thenReturn(user);
		  
		  String expected =
		  "{\"idUser\":1,\"name\":\"FARID\",\"birthday\":\"2000-11-01T00:00:00.000+00:00\",\"country\":\"French\",\"phone\":\"0628466847\",\"gender\":\"Male\"}";
		  
		  RequestBuilder requestBuilder = MockMvcRequestBuilders
		  .post("/api/users/create") .accept(MediaType.APPLICATION_JSON)
		  .content(expected) .contentType(MediaType.APPLICATION_JSON);
		  
		  MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		  
		  MockHttpServletResponse response = result.getResponse();
		  
		  assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		  
		  }
		 
		 
}