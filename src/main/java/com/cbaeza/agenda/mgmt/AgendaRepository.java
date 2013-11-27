package com.cbaeza.agenda.mgmt;

import com.cbaeza.agenda.model.Agendas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cbaeza
 * Date: 15.11.13
 * Time: 17:29
 * To change this template use File | Settings | File Templates.
 */
public interface AgendaRepository extends CrudRepository<Agendas, Integer> {

    /**
     * Find and return a List of all Agendas.
     *
     * @return return a List of all Agendas.
     */
    @Query("FROM Agendas")
    List<Agendas> findAllAgendas();
}
