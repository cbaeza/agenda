package com.cbaeza.agenda.controller;

import com.cbaeza.agenda.mgmt.AgendaRepository;
import com.cbaeza.agenda.model.Agendas;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * User: cbaeza
 * Since: 15.11.13
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    public static final String VIEW_NAME = "index";
    protected final Log LOG = LogFactory.getLog(getClass());
    @Autowired
    private AgendaRepository agendaRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(final ModelMap model) {
        LOG.debug("/index -> getAll");
        model.addAttribute("message", "hello from index");
        final List<Agendas> agendasArrayList = new ArrayList<>(0);
        final List<Agendas> all = agendaRepository.findAllAgendas();

        for (Agendas a : all) {
            agendasArrayList.add(a);
        }

        model.addAttribute("agendas", agendasArrayList);
        model.addAttribute("agendas_size", agendasArrayList.size());
        LOG.debug("Agenda entries: " + agendasArrayList.size());
        return VIEW_NAME;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getAgenda(@PathVariable("id") final String agendaID, final Model model) {
        LOG.debug("/index/{id} -> getAgenda");
        final Agendas agenda = agendaRepository.findOne(Integer.valueOf(agendaID));
        final List<Agendas> agendasArrayList = Arrays.asList(agenda);
        model.addAttribute("agendas", agendasArrayList);
        model.addAttribute("message", "done.");
        model.addAttribute("agendas_size", agendasArrayList.size());
        return VIEW_NAME;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newAgenda(final Model model) {
        LOG.debug("/index/new -> newAgenda");
        model.addAttribute("message", "Add new Agenda");
        model.addAttribute("agenda", new Agendas());
        return "agenda";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAgenda(@ModelAttribute("agenda") final Agendas agenda, final BindingResult result) {
        LOG.debug("/index/save -> saveAgenda");
        if (agenda == null) {
            throw new RuntimeException("Agenda must not be null");
        }
        final Date now = new Date();
        agenda.setCreatedAt(now);
        agenda.setUpdatedAt(now);
        agendaRepository.save(agenda);
        return "redirect:/index";
    }

}
