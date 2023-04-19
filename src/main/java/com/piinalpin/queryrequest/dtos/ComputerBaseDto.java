package com.piinalpin.queryrequest.dtos;

import lombok.Data;

@Data
public class ComputerBaseDto {
    private Long id;
    private String name;
    private String ipAddress;
    private String brandName;
}
