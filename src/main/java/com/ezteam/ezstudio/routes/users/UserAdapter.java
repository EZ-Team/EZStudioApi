package com.ezteam.ezstudio.routes.users;

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
public class UserAdapter extends AbstractAdapter {
    protected static AbstractEntity callEntityBuilder(AbstractDTO dto) {
        UserDTO curr = (UserDTO) dto;
        return UserEntity.builder()
                .id(curr.getId())
                .login(curr.getLogin())
                .password(curr.getPassword())
                .build();
    }
    protected static AbstractEntity callEntityBuilder(AbstractDomain domain) {
        User curr = (User) domain;
        return UserEntity.builder()
                .login(curr.getLogin())
                .password(curr.getPassword())
                .build();
    }

    protected static AbstractDTO callDtoBuilder(AbstractEntity entity) {
        UserEntity curr = (UserEntity) entity;
        return UserDTO.builder()
                .id(curr.getId())
                .login(curr.getLogin())
                .password(curr.getPassword())
                .build();
    }
    protected static AbstractDTO callDtoBuilder(AbstractDomain domain) {
        User curr = (User) domain;
        return UserDTO.builder()
                .login(curr.getLogin())
                .password(curr.getPassword())
                .build();
    }

    protected static AbstractDomain callDomainBuilder(AbstractEntity entity) {
        UserEntity curr = (UserEntity) entity;
        return User.builder()
                .login(curr.getLogin())
                .password(curr.getPassword())
                .build();
    }
    protected static AbstractDomain callDomainBuilder(AbstractDTO dto) {
        UserDTO curr = (UserDTO) dto;
        return User.builder()
                .login(curr.getLogin())
                .password(curr.getPassword())
                .build();
    }

}
