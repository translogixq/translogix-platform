package de.shein.logix.repositories;

import de.shein.logix.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Users, Long> {
}
