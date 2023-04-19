package com.piinalpin.queryrequest.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ipAddress;
    private String brandName;

    @ManyToOne(fetch = FetchType.LAZY)
    private OperatingSystem operatingSystem;

}
