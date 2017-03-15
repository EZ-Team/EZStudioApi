package com.ezteam.ezstudio.abstractions.data;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Aurelien
 * @file NotFoundException
 * @description
 * @package com.ezteam.ezstudio.abstractions.data
 * @date 15-Mar-17
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{}
