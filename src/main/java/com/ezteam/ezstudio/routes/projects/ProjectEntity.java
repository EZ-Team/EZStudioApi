package com.ezteam.ezstudio.routes.projects;

import com.ezteam.ezstudio.abstractions.data.AbstractEntity;
import com.ezteam.ezstudio.routes.instruments.InstrumentEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@NoArgsConstructor
@Table(name = "projects")
public class ProjectEntity extends AbstractEntity {

    @Id
    @GeneratedValue
    @OneToOne(mappedBy = "authorId")
    protected Long id;

    private Long authorId;

    @Column
    private Double status;

    @Enumerated(EnumType.STRING)
    @Column
    private ProjectType type;

    @ManyToOne(targetEntity = ProjectEntity.class, cascade = CascadeType.ALL)
    private ProjectEntity parent;

    @OneToMany(targetEntity = ProjectEntity.class, mappedBy = "id")
    private List<ProjectEntity> children;

    @ManyToMany(targetEntity = InstrumentEntity.class)
    private List<InstrumentEntity> instruments;

    @CreationTimestamp
    protected Date creationDate;

    @UpdateTimestamp
    protected Date lastUpdate;
}
