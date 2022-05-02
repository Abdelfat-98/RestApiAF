# RestApiAF

Users Rest Api for Air France

+++++++++ To use this Api you should download and install lombok +++++++++

+++++++++ Yous should change database configuration into application.properties file +++++++++

+++++++++ To show Api documentation you should use this url : http://@IP:Port/swagger.html +++++++++

+++++++++ you should change the logging file location into application.properties file +++++++++

#Consuming Api

1) To create user you should use this url : http://@IP:Port/api/users/create 
   You can use the Api documentation to see the request body and more details

2) To show user details you should use this usrl : http://@IP:Port/api/users/finduser/{name}
   You can use the Api documentation to see more details
   
3) To show the list of all created users you should this url http://@IP:Port/api/users/allusers
   You can use the Api documentation to see more details
   
4) To run Unit test you can run the test class /src/test/java/rest/afproject/api/UsersControllerTests.java
