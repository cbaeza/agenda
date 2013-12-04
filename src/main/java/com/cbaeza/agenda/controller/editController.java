package com.cbaeza.agenda.controller;

import com.cbaeza.agenda.mgmt.AgendaRepository;
import com.cbaeza.agenda.model.Agendas;
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
    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    private AgendaRepository agendaRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String init(final ModelMap model) {
        model.addAttribute("message", "hello from edit controller");
        return VIEW_NAME;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getAgenda(@PathVariable("id") String agendaID, final ModelMap modelMap) {
        final Agendas agenda = agendaRepository.findOne(Integer.valueOf(agendaID));
        modelMap.addAttribute("agenda", agenda);
        modelMap.addAttribute("message", "hello from edit controller");
        return "edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateAgendaEntry(@ModelAttribute("agenda") Agendas agenda, BindingResult result) {
        if (agenda == null) {
            throw new RuntimeException("Agenda must not be null");
        }
        //TODO: find a way to handle Dates in form and read only values
        agenda.setUpdatedAt(new Date());
        agendaRepository.save(agenda);
        return "redirect:/index";
    }


}