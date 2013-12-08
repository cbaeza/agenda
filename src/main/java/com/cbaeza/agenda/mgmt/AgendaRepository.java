package com.cbaeza.agenda.mgmt;

import com.cbaeza.agenda.model.Agenda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * User: cbaeza
 * Since: 15.11.13
 */
public interface AgendaRepository extends CrudRepository<Agenda, Integer> {

    /**
     * Find and return a List of all Agendas.
     *
     * @return return a List of all Agendas.
     */
    @Query("FROM Agenda")
    List<Agenda> findAllAgendas();
}
