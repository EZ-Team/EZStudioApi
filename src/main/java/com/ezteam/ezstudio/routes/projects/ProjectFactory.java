package com.ezteam.ezstudio.routes.projects;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by aurelien on 01/04/17.
 */
@Component
@Slf4j
public class ProjectFactory {

    private static final String UNKNOWN_TYPE_MESSAGE = "Unknown project type has been given : received \"{}\"";

    public Project make(ProjectType type) {
        Project output;

        switch(type) {
            case ALBUM:
                output = Album.builder().build();
                break;
            case TRACK:
                output = Track.builder().build();
                break;
            case SECTION:
                output = Album.builder().build();
                break;
            case INSTRUMENT:
                output = Track.builder().build();
                break;
            default:
                log.error(UNKNOWN_TYPE_MESSAGE, type);
                throw new IllegalArgumentException(String.format(UNKNOWN_TYPE_MESSAGE, type));
        }

        return output;
    }
}
