package com.ezteam.ezstudio.routes.users;

import com.ezteam.ezstudio.abstractions.data.AbstractEntity;
import com.ezteam.ezstudio.routes.instruments.InstrumentEntity;
import com.ezteam.ezstudio.routes.projects.ProjectType;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
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
public class UserEntity extends AbstractEntity {

    @Id
    @GeneratedValue
    @OneToOne(mappedBy = "authorId")
    protected Long id;

    private String login;
    private String password;
}
