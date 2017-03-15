package com.ezteam.ezstudio.routes.projects;

import com.ezteam.ezstudio.abstractions.data.*;
import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aurelien on 04-Mar-17.
 */
@Getter
@Setter
@RestController
@RequestMapping("/projects")
public class ProjectController extends AbstractController<ProjectAdapter, ProjectEntity, ProjectDTO>{

}
