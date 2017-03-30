package com.ezteam.ezstudio.routes.projects;

import com.ezteam.ezstudio.abstractions.data.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aurelien on 04-Mar-17.
 */
@RestController
@RequestMapping("/projects")
public class ProjectController extends AbstractController<ProjectDTO, ProjectService>{

}
