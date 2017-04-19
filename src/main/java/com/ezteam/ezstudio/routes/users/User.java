package com.ezteam.ezstudio.routes.users;

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
public class User extends AbstractDomain {

    private String login;
    private String password;
}
