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
import java.util.Arrays;
import java.util.List;

/**
 * User: cbaeza
 * Since: 15.11.13
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    public static final String VIEW_NAME = "index";
    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    private AgendaRepository agendaRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(final ModelMap model) {

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getAgenda(@PathVariable("id") String agendaID, final Model model) {

        final Agendas agenda = agendaRepository.findOne(Integer.valueOf(agendaID));
        final List<Agendas> agendasArrayList = Arrays.asList(agenda);
        model.addAttribute("agendas", agendasArrayList);
        model.addAttribute("message", "done.");
        model.addAttribute("agendas_size", agendasArrayList.size());
        return VIEW_NAME;
    }

}
