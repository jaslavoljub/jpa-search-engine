package com.piinalpin.queryrequest.service;

import com.piinalpin.queryrequest.domain.common.query.SearchRequest;
import com.piinalpin.queryrequest.domain.common.query.SearchSpecification;
import com.piinalpin.queryrequest.domain.dao.Computer;
import com.piinalpin.queryrequest.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ComputerService {
    @Autowired
    ComputerRepository computerRepository;

    public Page<Computer> searchComputer(SearchRequest request) {
        SearchSpecification<Computer> specification = new SearchSpecification<>(request);
        Pageable pageable = SearchSpecification.getPageable(request.getPage(), request.getSize());
        return computerRepository.findAll(specification, pageable);
    }

}
