package com.piinalpin.queryrequest.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OperatingSystem implements Serializable {

    private static final long serialVersionUID = -1730538653948604611L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String version;
    private String kernel;
    private LocalDateTime releaseDate;
    private Integer usages;

    @OneToMany(mappedBy = "operatingSystem", cascade = CascadeType.ALL)
    private List<Computer> computers = new ArrayList<>();

}
