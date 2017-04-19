package com.ezteam.ezstudio.routes.instruments.types;

import com.ezteam.ezstudio.abstractions.data.AbstractEntity;
import com.ezteam.ezstudio.routes.instruments.InstrumentEntity;
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
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class InstrumentTypeEntity extends AbstractEntity {

    @Id
    @GeneratedValue
    protected Long id;

    private String name;

    @OneToMany(targetEntity = InstrumentEntity.class, mappedBy = "id")
    private List<InstrumentEntity> instruments;

    @ManyToMany(targetEntity = ProjectEntity.class)
    private List<ProjectEntity> projects;
}
