package com.food.common;

import com.food.exception.ExceptionForm;
import com.food.form.EmailForm;
import com.food.model.User;
import com.food.repository.UserRepository;
import com.food.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;

/**
 * Created by Hue on 11/26/2016.
 */
@RestController
public class SendMailController {

    @Autowired
    private SmtpMailSender smtpMailSender;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/send-mail", method = RequestMethod.POST)
    public ResponseEntity sendMail(@Valid @RequestBody EmailForm form, BindingResult bindingResult) throws MessagingException {
        if(bindingResult.hasErrors()){
            throw new ExceptionForm(bindingResult);
        }
        String emailE = userRepository.getEmail(form.getEmail());
        if(emailE == null){
            throw new ExceptionForm("Email", ExceptionForm.ERROR_CODE.EXIST, "Email is not exist");
        }
        String text = Common.randomString();
        User user = userRepository.findByEmail(form.getEmail());
        smtpMailSender.send(form.getEmail(), "Reset password FFV", "This is your code: " + text);
        user.setPwd(text);
        userRepository.save(user);
        return ResponseEntity.ok("Authentication code has been sent to your email.\nPlease check your email");
    }
}
