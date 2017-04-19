package com.ezteam.ezstudio.routes.users;

import com.ezteam.ezstudio.abstractions.data.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aurelien on 04-Mar-17.
 */
@RestController
@RequestMapping("/users")
public class UserController extends AbstractController<UserDTO, UserService>{

}
