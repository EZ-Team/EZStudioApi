package com.ezteam.ezstudio.routes.users;

import com.ezteam.ezstudio.abstractions.data.AbstractEntity;
import com.ezteam.ezstudio.routes.instruments.InstrumentEntity;
import com.ezteam.ezstudio.routes.projects.ProjectType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
public class UserEntity extends AbstractEntity {

    @Id
    @GeneratedValue
    protected Long id;

    private String login;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean enabled;

    @CreationTimestamp
    protected Date creationDate;

    @UpdateTimestamp
    protected Date lastUpdate;
}
