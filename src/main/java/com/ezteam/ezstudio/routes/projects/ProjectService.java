package com.ezteam.ezstudio.routes.projects;

import com.ezteam.ezstudio.abstractions.data.AbstractService;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @file AbstractService.java
 * @description Abstraction for Service pattern that defines the actions that objects will use for CRUD treatments
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
@Getter
@Setter
@Builder
public class ProjectService extends AbstractService<ProjectAdapter, ProjectEntity, ProjectDTO> {

}
