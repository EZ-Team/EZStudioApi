package com.ezteam.ezstudio.abstractions.data;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Aurelien
 * @file InvalidException
 * @description
 * @package com.ezteam.ezstudio.abstractions.data
 * @date 15-Mar-17
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidException extends RuntimeException {}
