package com.ezteam.ezstudio.routes.projects;

import com.ezteam.ezstudio.abstractions.data.AbstractAdapter;
import com.ezteam.ezstudio.abstractions.data.AbstractDTO;
import com.ezteam.ezstudio.abstractions.data.AbstractDomain;
import com.ezteam.ezstudio.abstractions.data.AbstractEntity;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @file AbstractAdapter.java
 * @description Abstraction for Adapter pattern for DTO/Entity conversion
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
public class ProjectAdapter extends AbstractAdapter {
    protected static AbstractEntity callEntityBuilder(AbstractDTO dto) {
        ProjectDTO curr = (ProjectDTO) dto;
        return ProjectEntity.builder()
                .id(curr.getId())
                .authorId(curr.getAuthorId())
                .status(curr.getStatus())
                .build();
    }
    protected static AbstractEntity callEntityBuilder(AbstractDomain domain) {
        Project curr = (Project) domain;
        return ProjectEntity.builder()
                .authorId(curr.getAuthorId())
                .status(curr.getStatus())
                .build();
    }

    protected static AbstractDTO callDtoBuilder(AbstractEntity entity) {
        ProjectEntity curr = (ProjectEntity) entity;
        return ProjectDTO.builder()
                .id(curr.getId())
                .authorId(curr.getAuthorId())
                .parent(parentToLong(curr))
                .children(childrenToLongList(curr))
                .status(curr.getStatus())
                .build();
    }
    protected static AbstractDTO callDtoBuilder(AbstractDomain domain) {
        Project curr = (Project) domain;
        return ProjectDTO.builder()
                .authorId(curr.getAuthorId())
                .parent(curr.getParent())
                .children(curr.getChildren())
                .status(curr.getStatus())
                .build();
    }

    protected static AbstractDomain callDomainBuilder(AbstractEntity entity) {
        ProjectEntity curr = (ProjectEntity) entity;
        return Project.builder()
                .authorId(curr.getAuthorId())
                .parent(parentToLong(curr))
                .children(childrenToLongList(curr))
                .status(curr.getStatus())
                .build();
    }
    protected static AbstractDomain callDomainBuilder(AbstractDTO dto) {
        ProjectDTO curr = (ProjectDTO) dto;
        return Project.builder()
                .authorId(curr.getAuthorId())
                .parent(curr.getParent())
                .children(curr.getChildren())
                .status(curr.getStatus())
                .build();
    }

    private static List<Long> childrenToLongList(ProjectEntity entity) {
        return entity != null ?
                Lists.transform(entity.getChildren(),
                        (child) -> child != null ? child.getId() : null) :
                null;
    }

    private static Long parentToLong(ProjectEntity entity) {
        return entity != null ?
                entity.getParent().getId() :
                null;
    }

}
