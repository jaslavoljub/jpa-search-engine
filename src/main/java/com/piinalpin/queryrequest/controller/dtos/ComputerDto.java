package com.piinalpin.queryrequest.controller.dtos;

import lombok.Data;

@Data
public class ComputerDto {
    private Long id;
    private String name;
    private String ipAddress;
    private String brandName;
    private OperatingSystemCommonDto operatingSystem;
}
