package cl.transTest.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import cl.transTest.domain.User;
import cl.transTest.exception.ServiceException;
import cl.transTest.service.SecurityService;
import cl.transTest.service.UserService;
import cl.transTest.utils.UserValidator;

/**
 * UserController - Clase para la gestion de acciones de Usuario, además interaccion con las vistas JSP
 * 
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */

@Controller
public class UserController {
	
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
        
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
      
    	userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Tu usuario y password son invalidos.");

        if (logout != null)
            model.addAttribute("message", "Te haz logeado de forma exitosa.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
    
    @GetMapping("/v1/listUser")
	public ResponseEntity<List<User>> listUser() throws ServiceException{
	  	List<User> listSale= userService.findAll();
		return new ResponseEntity<>(listSale, HttpStatus.OK);
	}
}
