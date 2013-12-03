package com.cbaeza.agenda.controller;

import com.cbaeza.agenda.mgmt.AgendaRepository;
import com.cbaeza.agenda.model.Agendas;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;

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
}