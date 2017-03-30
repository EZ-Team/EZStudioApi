package com.ezteam.ezstudio.routes.projects;

import com.ezteam.ezstudio.abstractions.data.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;

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
public class ProjectEntity extends AbstractEntity {

}
