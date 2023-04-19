package com.piinalpin.queryrequest.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OperatingSystemBaseDto {
    private Long id;
    private String name;
    private String version;
    private String kernel;
    private LocalDateTime releaseDate;
    private Integer usages;
}
