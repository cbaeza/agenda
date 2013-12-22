package com.cbaeza.agenda.controller;

import com.cbaeza.agenda.mgmt.UserRepository;
import com.cbaeza.agenda.model.Agenda;
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
import org.springframework.web.portlet.ModelAndView;

import java.util.Date;

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
    public String init(@ModelAttribute("user") final User user, final ModelMap model) {
        model.addAttribute("message", "Please enter login information");
        model.addAttribute("user", user);
        return VIEW_NAME;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") final User user, final BindingResult result) {
        LOG.debug("/login/login -> login");
        if (user == null) {
            throw new RuntimeException("User must not be null");
        }
        //TODO:
        // - find user
        // - validate credentials - user Encription

        return "redirect:/index";
    }

}
