package com.ezteam.ezstudio.routes.projects;

import com.ezteam.ezstudio.abstractions.data.AbstractDTO;
import lombok.*;

import java.util.List;

/**
 * @file AbstractDTO.java
 * @description Abstraction for DTO (Data Transfer Object) pattern that defines objects in Java runtime context
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
@Data
@Builder
public class ProjectDTO extends AbstractDTO {

    private Long id;

    private Long authorId;

    private Double status;

    private ProjectType type;

    private Long parent;

    private List<Long> children;
}
