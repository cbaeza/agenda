package com.cbaeza.agenda.controller;

import com.cbaeza.agenda.mgmt.AgendaRepository;
import com.cbaeza.agenda.model.Agenda;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * User: cbaeza
 * Since: 27.11.13
 */
@Controller
@SessionAttributes
@RequestMapping("/edit")
public class EditController {

    public static final String VIEW_NAME = "edit";
    protected final Log LOG = LogFactory.getLog(getClass());
    @Autowired
    private AgendaRepository agendaRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String init(final ModelMap model) {
        LOG.debug("/edit/ -> init");
        model.addAttribute("message", "hello from edit controller");
        return VIEW_NAME;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getAgenda(@PathVariable("id") final String agendaID, final ModelMap modelMap) {
        LOG.debug("/edit/{id} -> getAgenda");
        final Agenda agenda = agendaRepository.findOne(Integer.valueOf(agendaID));
        modelMap.addAttribute("agenda", agenda);
        modelMap.addAttribute("message", "hello from edit controller");
        return "edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateAgenda(@ModelAttribute("agenda") final Agenda agenda, final BindingResult result) {
        LOG.debug("/edit/update -> updateAgenda");
        if (agenda == null) {
            throw new RuntimeException("Agenda must not be null");
        }
        agenda.setUpdatedAt(new Date());
        agendaRepository.save(agenda);
        return "redirect:/index";
    }


}