package com.piinalpin.queryrequest.controller;

import com.piinalpin.queryrequest.controller.dtos.ComputerDto;
import com.piinalpin.queryrequest.controller.dtos.OperatingSystemDto;
import com.piinalpin.queryrequest.domain.common.query.SearchRequest;
import com.piinalpin.queryrequest.domain.dao.Computer;
import com.piinalpin.queryrequest.domain.dao.OperatingSystem;
import com.piinalpin.queryrequest.service.ComputerService;
import com.piinalpin.queryrequest.service.ObjectMapperUtils;
import com.piinalpin.queryrequest.service.OperatingSystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OperatingSystemController {

    @Autowired
    private OperatingSystemService operatingSystemService;

    @Autowired
    private ComputerService computerService;

    @PostMapping(value = "/searchOS", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<OperatingSystemDto> searchOS(@RequestBody SearchRequest request) {
        Page<OperatingSystem> result = operatingSystemService.searchOperatingSystem(request);
        return result.map(source -> {
            return ObjectMapperUtils.map(source, OperatingSystemDto.class);
        });
    }

    @PostMapping(value = "/searchComputer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<ComputerDto> searchComputer(@RequestBody SearchRequest request) {
        Page<Computer> result = computerService.searchComputer(request);
        return result.map(source -> {
            return ObjectMapperUtils.map(source, ComputerDto.class);
        });
    }

}
