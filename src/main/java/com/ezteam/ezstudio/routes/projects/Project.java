package com.ezteam.ezstudio.routes.projects;

import com.ezteam.ezstudio.abstractions.data.AbstractDomain;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by a70850 on 30/03/2017.
 */
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Project extends AbstractDomain {

    private Long authorId;

    private Double status;

    private ProjectType type;

    private Long parent;

    private List<Long> children;
}
