package com.ezteam.ezstudio.routes.instruments;

import com.ezteam.ezstudio.abstractions.data.AbstractEntity;
import com.ezteam.ezstudio.routes.instruments.types.InstrumentTypeEntity;
import com.ezteam.ezstudio.routes.projects.ProjectEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @file AbstractDTO.java
 * @description Abstraction for Spring JPA (Java Persistence API) Entity pattern that defines objects in JPA database context
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
@Entity
@Data
@Builder
@Table(name = "Instrument")
public class InstrumentEntity extends AbstractEntity {

    private String name;

    @ManyToOne(targetEntity = ProjectEntity.class, cascade = CascadeType.ALL)
    private InstrumentTypeEntity category;

    @ManyToMany(targetEntity = ProjectEntity.class)
    private List<ProjectEntity> projects;
}
