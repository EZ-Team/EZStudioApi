package com.ezteam.ezstudio.routes.users;

import com.ezteam.ezstudio.abstractions.data.AbstractDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
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
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDTO extends AbstractDTO {

    private Long id;
    @NotNull
    private String login;
    @NotNull
    private String password;
    private Role role;
    private boolean enabled;
}
