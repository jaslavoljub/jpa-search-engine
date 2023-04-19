package com.piinalpin.queryrequest.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class OperatingSystemDto {
    private Long id;
    private String name;
    private String version;
    private String kernel;
    private LocalDateTime releaseDate;
    private Integer usages;
    private List<ComputerBaseDto> computers;
}
