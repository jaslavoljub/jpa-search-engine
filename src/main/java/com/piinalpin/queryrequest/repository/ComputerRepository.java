package com.piinalpin.queryrequest.repository;

import com.piinalpin.queryrequest.domain.dao.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ComputerRepository extends JpaRepository<Computer, Long>,
        JpaSpecificationExecutor<Computer> {
}
