package com.cbaeza.agenda.mgmt;

import com.cbaeza.agenda.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * User: cbaeza
 * Since: 22.12.13
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
