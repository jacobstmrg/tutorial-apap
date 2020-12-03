package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.UserModel;
import apap.tutorial.haidokter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user, RedirectAttributes attributes){
        String feedback = userService.addUser(user);
        attributes.addFlashAttribute("notif", feedback);
        return "redirect:/";
    }

//    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
//    private String changePasswordSubmit(
//            @RequestParam(value = "oldPassword") String oldPassword,
//            @RequestParam(value = "newPassword") String newPassword,
//            @RequestParam(value = "newPassword2") String newPassword2,
//            HttpServletRequest request,
//            Model model
//    ) {
//        Principal principal = request.getUserPrincipal();
//        UserModel user = userService.findUser(principal.getName());
//        if(!newPassword.equals(newPassword2)){
//            model.addAttribute("warning", "password baru tidak match, mohon input ulang");
//            return "form-change-password";
//        }
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        if(passwordEncoder.matches(oldPassword, user.getPassword())){
//            userService.changePassword(user, newPassword);
//        }
//        else{
//            model.addAttribute("warning", "password lama tidak match, mohon input ulang");
//            return "form-change-password";
//        }
//        return "redirect:/";
//    }
    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    private String changePasswordForm(
            Model model){
        return "form-change-password";
    }


    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    private String changePasswordSubmit(
            @RequestParam(value = "passwordOld") String passwordOld,
            @RequestParam(value = "passwordNew") String passwordNew,
            @RequestParam(value = "passwordNew2") String passwordNew2,
            HttpServletRequest request,
            RedirectAttributes attributes,
            Model model
    ) {
        Principal principal = request.getUserPrincipal();
        UserModel user = userService.findUser(principal.getName());
        if(!passwordNew.equals(passwordNew2)){
            model.addAttribute("notif", "Password baru tidak match, mohon input ulang");
            return "form-change-password";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(passwordEncoder.matches(passwordOld, user.getPassword())){
            String feedback = userService.changePassword(user, passwordNew);
            attributes.addFlashAttribute("notif", feedback);
            return "redirect:/user/changePassword";
        }
        else{
            model.addAttribute("notif", "Password lama salah, mohon input ulang");
            return "form-change-password";
        }
    }
}
