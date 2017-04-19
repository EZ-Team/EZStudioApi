package com.ezteam.ezstudio.routes.users;

import com.ezteam.ezstudio.abstractions.data.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * @file AbstractService.java
 * @description Abstraction for Service pattern that defines the actions that objects will use for CRUD treatments
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
@Service
public class UserService extends AbstractService<UserAdapter, UserEntity, UserDTO, UserRepository> {

    @Transactional
    public UserDTO create(UserDTO dto) {
        MessageDigest mda = null;
        try {
            mda = MessageDigest.getInstance("SHA-512", "BC");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        if(mda == null) {
            return null;
        }

        String password = mda.digest(dto.getPassword().getBytes()).toString();
        dto.setPassword(password);
        return super.create(dto);
    }


}
