package com.ezteam.ezstudio.routes.projects;

import com.ezteam.ezstudio.abstractions.data.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @file AbstractRepository.java
 * @description Abstraction for Spring Repository pattern, easier to redefine
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
@Repository
public interface ProjectRepository extends AbstractRepository<ProjectEntity> {

}
