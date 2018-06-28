package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.dao.RoleDao;
import project.model.Think;
import project.model.User;
import project.service.ThinkService;
import project.service.UserService;

import java.util.*;


@Controller
public class HomeController {

    @Autowired
    public UserService userService;

    @Autowired
    public RoleDao roleDao;

    @Autowired
    public ThinkService thinkService;

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String home(Model model){
        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("thinks", getThinks());
        model.addAttribute("Subscriptions", user.getSubscriptions().size());
        model.addAttribute("Subscribers", user.getSubscribers().size());
        return "greeting";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String send(@RequestParam(name = "text") String text,Model model){
        if(text.equals("")){
            model.addAttribute("errorMessage", "Введите вашу мысль!");
            model.addAttribute("thinks", getThinks());
            return "greeting";
        }

        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        User author = userService.findByUsername(user.getName());
        Think think = new Think(author, text);
        thinkService.save(think);
        model.addAttribute("Subscriptions", author.getSubscriptions().size());
        model.addAttribute("Subscribers", author.getSubscribers().size());
        return "redirect:/";
    }

    @GetMapping("/news")
    public String news(Model model){
        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Think> thinks = new LinkedList<>();
        List<User> users = user.getSubscriptions();
        for(User iUser : users){
            thinks.addAll(iUser.getThinks());
        }
        if(thinks != null){
            thinks.sort(((o1, o2) -> o1.getId().compareTo(o2.getId())));
            Collections.reverse(thinks);
            model.addAttribute("thinks", thinks);
        }
        return "news";
    }

    @GetMapping("/login")
    public String hello()
    {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(){
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String confirmRegistration(@RequestParam(name = "username") String email,
                                      @RequestParam(name = "pass") String password,
                                      Model model){
        if(email.length()==0) { model.addAttribute("emailerror", "Введите E-mail");
            return "registration";}

        if(userService.findByUsername(email) != null){ model.addAttribute("emailerror", "Данный E-mail уже занят");
            return "registration";}

        if(password.contains(" ") || password.length()<6 || password.length()>16){ model.addAttribute("passerror", "Некорректный ввод пароля");
        return "registration";}

        User user = new User(email, password);
        user.setRole(roleDao.getOne(1L));
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping(value = "/{username}")
    public String userProfile(@PathVariable("username") String username, Model model){
        if(SecurityContextHolder.getContext().getAuthentication().getName().equals(username)) return "redirect:/";
            User thisUser = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            User findUser = userService.findByUsername(username);
            try {
                List<Think> thinks = userService.findByUsername(username).getThinks();
                Collections.reverse(thinks);
                if (thinks.size() != 0) model.addAttribute("thinks", thinks);
            }
            catch (NullPointerException e){
                return "erroruser";
            }
            model.addAttribute("isSubscriptions", findUser.getSubscribers().contains(thisUser));
            model.addAttribute("Subscriptions", findUser.getSubscriptions().size());
            model.addAttribute("Subscribers", findUser.getSubscribers().size());
            System.out.println(findUser.getSubscribers().contains(thisUser));
            model.addAttribute("userChanel", findUser);
            return "user";
    }

    @GetMapping(value = "/user/subscribe/{userid}")
    public String userSubscribe(@PathVariable("userid") Long id, Model model){
            User user = userService.findById(id).get();
            if(user != null){
                User thisUser = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
                user.getSubscribers().add(thisUser);
                userService.saveUser(user);
                return "redirect:/" + user.getName();
            }
            else {
                return "erroruser";
            }
    }

    @GetMapping(value = "/user/unsubscribe/{userid}")
    public String userUnSubscribe(@PathVariable("userid") Long id, Model model){
        User user = userService.findById(id).get();
        if(user != null){
            User thisUser = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            user.getSubscribers().remove(thisUser);
            userService.saveUser(user);
            return "redirect:/" + user.getName();
        }
        else {
            return "erroruser";
        }
    }

    private List<Think> getThinks(){
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        User thisUser = userService.findByUsername(user.getName());
        List<Think> thinks = thisUser.getThinks();
        Collections.reverse(thinks);
        return thinks;
    }
}
