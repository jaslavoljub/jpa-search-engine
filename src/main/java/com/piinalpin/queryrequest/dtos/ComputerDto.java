package com.piinalpin.queryrequest.dtos;

import lombok.Data;

@Data
public class ComputerDto {
    private Long id;
    private String name;
    private String ipAddress;
    private String brandName;
    private OperatingSystemBaseDto operatingSystem; // <--- This line is optional, no effect on filters
}
