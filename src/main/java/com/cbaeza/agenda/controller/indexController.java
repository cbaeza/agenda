package com.cbaeza.agenda.controller;

import com.cbaeza.agenda.mgmt.AgendaRepository;
import com.cbaeza.agenda.model.Agendas;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * User: cbaeza
 * Since: 15.11.13
 */
@Controller
/*@RequestMapping("/index")*/
public class indexController {

    public static final String VIEW_NAME = "index";
    protected final Log logger = LogFactory.getLog(getClass());
    private String viewName;
    @Autowired
    private AgendaRepository agendaRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String printWelcome(final ModelMap model) {

        model.addAttribute("message", "hello from index");
        final List<Agendas> agendasArrayList = new ArrayList<>(0);
        final List<Agendas> all = agendaRepository.findAllAgendas();

        for (Agendas a : all) {
            agendasArrayList.add(a);
        }

        model.addAttribute("agendas", agendasArrayList);
        model.addAttribute("agendas_size", agendasArrayList.size());
        return VIEW_NAME;
    }

    @RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
    public Model showUserForm(@PathVariable("id") Agendas agendaID, final Model model) {
        //final Agendas agenda = agendaRepository.findOne(agendaID);
        model.addAttribute("entry", agendaID);
        return model;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
}
