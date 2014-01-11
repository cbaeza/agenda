package com.cbaeza.agenda.controller;

import com.cbaeza.agenda.mgmt.UserRepository;
import com.cbaeza.agenda.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * User: cbaeza
 * Since: 22.12.13
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    public static final String VIEW_NAME = "login";
    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String init(@ModelAttribute("user") final User user, Principal principal, final ModelMap model) {
        model.addAttribute("message", "Please enter login information");
        model.addAttribute("user", user);
        model.addAttribute("user_logged", (principal != null) ? principal.getName() : "no user authenticated");
        return VIEW_NAME;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") final User user, final BindingResult result, final ModelMap model) {
        LOG.debug("/login/login -> login");
        if (user == null) {
            throw new RuntimeException("User must not be null");
        }
        //TODO:
        // - find user
        // - validate credentials - user Encription
        model.addAttribute("user_logged", "unknow");
        return "redirect:/index";
    }

}
