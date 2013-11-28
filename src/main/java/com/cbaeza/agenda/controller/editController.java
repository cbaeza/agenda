package com.cbaeza.agenda.controller;

import com.cbaeza.agenda.mgmt.AgendaRepository;
import com.cbaeza.agenda.model.Agendas;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: cbaeza
 * Since: 27.11.13
 */
@Controller
@RequestMapping("/edit")
public class editController {

    public static final String VIEW_NAME = "edit";
    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    private AgendaRepository agendaRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getAgenda(@PathVariable("id") String agendaID, final Model model) {
        final Agendas agenda = agendaRepository.findOne(Integer.valueOf(agendaID));
        model.addAttribute("agenda", agenda);
        return VIEW_NAME;
    }
}
