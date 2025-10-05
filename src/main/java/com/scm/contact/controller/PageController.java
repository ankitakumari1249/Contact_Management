package com.scm.contact.controller;

import java.lang.management.MemoryType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.contact.entities.User;
import com.scm.contact.forms.UserForm;
import com.scm.contact.helper.Message;
import com.scm.contact.helper.MessageType;
import com.scm.contact.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

  @Autowired
  private UserService userService;

  //  @GetMapping("/")
  //   public String index() {
  //       return "redirect:/home";
  //   }

  @RequestMapping("/home")
  public String home(Model model) {
    System.out.println("This is HOME page");
    model.addAttribute("name", "Substring Technologies");
    model.addAttribute("Yourname", "Ankita Kumari");
    model.addAttribute("githubrepo", "https://github.com/fenil2144/JBDL77");
    return "home";
  }

  @RequestMapping("/about")
  public String aboutPage(Model model) {
    System.out.println("About page loading");
    model.addAttribute("isLogin", true);
    return "about";
  }

  @RequestMapping("/service")
  public String servicesPage() {
    System.out.println("this is service page");
    return "service";
  }

  @RequestMapping("/contact")
  public String contactUsPage() {
    System.out.println("this is ContactUs Page");
    return "contact";
  }

  @RequestMapping("/login")
  public String loginPage() {
    System.out.println("this is Login Page");
    return "login";
  }

  @RequestMapping("/register")
  public String registerPage(Model model) {
    UserForm userForm = new UserForm();
    model.addAttribute("userForm", userForm);
    System.out.println("this is Register Page");
    return "register";
  }

  // processing register
  @RequestMapping(value = "/do-register", method = RequestMethod.POST)
  public String processRegister(@Valid @ModelAttribute UserForm userForm,BindingResult rBindingResult ,HttpSession session) {
    System.out.println("Processing registration");

    // fetch form data
    // UserForm
    System.out.println(userForm);
   if(rBindingResult.hasErrors()){
    return "register";
   }
    User user = new User();
    user.setName(userForm.getName());
    user.setEmail(userForm.getEmail());
    user.setPassword(userForm.getPassword());
    user.setAbout(userForm.getAbout());
    user.setPhoneNumber(userForm.getPhoneNumber());
    user.setProfilePic(
        "https://in.images.search.yahoo.com/search/images?p=default+profile+picture&fr=mcafee&type=E210IN1000G0&imgurl=https%3A%2F%2Fuxwing.com%2Fwp-content%2Fthemes%2Fuxwing%2Fdownload%2Fpeoples-avatars%2Fdefault-profile-picture-male-icon.png#id=36&iurl=https%3A%2F%2Fuxwing.com%2Fwp-content%2Fthemes%2Fuxwing%2Fdownload%2Fpeoples-avatars%2Fdefault-profile-picture-male-icon.png&action=click");

    User savedUser = userService.saveUser(user);
    System.out.println("user saved");
    
Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();

    session.setAttribute("message",message);


    return "redirect:/register";

  }
}
