package com.piinalpin.queryrequest.controller.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OperatingSystemCommonDto {
    private Long id;
    private String name;
    private String version;
    private String kernel;
    private LocalDateTime releaseDate;
    private Integer usages;
}
