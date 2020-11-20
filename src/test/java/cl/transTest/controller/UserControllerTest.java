package cl.transTest.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cl.transTest.domain.User;
import cl.transTest.presentation.UserController;

import java.util.ArrayList;
import java.util.List;
/**
 * UserControllerTest - Clase test para controlador de usuario
 *
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    private static User p1;
    private static User p2;
    private static User p3;

    @Mock
    private UserController userController;


    @BeforeAll
    public static void init() {
     
        p1 = new User(1L,"","","");
        p2 = new User(2L,"","","");
        p3 = new User(3L,"","","");

    }

   
    @Test
    void findAll_whenNoRecord(){
    	List<User> list= new ArrayList<User>();	  
    	ResponseEntity<List<User>> re= new ResponseEntity<>(list, HttpStatus.OK);	
        Mockito.when(userController.listUser()).thenReturn(re);
        assertThat(userController.listUser().getBody().size(), is(0));
        Mockito.verify(userController, Mockito.times(1)).listUser();
    }

    @Test
    void findAll_whenRecord() {
       
    	List<User> list= new ArrayList<User>();	  
    	list.add(p1);
    	list.add(p2);
    	list.add(p3);
    	
    	ResponseEntity<List<User>> re= new ResponseEntity<>(list, HttpStatus.OK);	
        Mockito.when(userController.listUser()).thenReturn(re);  
        assertThat(userController.listUser().getBody().size(), is(3));
        Mockito.verify(userController, Mockito.times(1)).listUser();
    }


    
   
}
 