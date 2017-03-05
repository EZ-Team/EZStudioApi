package com.ezteam.ezstudio.abstractions.data;

import lombok.*;

import java.io.Serializable;

/**
 * @file AbstractDTO.java
 * @description Abstraction for DTO (Data Transfer Object) pattern that defines objects in Java runtime context
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public abstract class AbstractDTO implements Serializable {
    @NonNull
    protected Long id;
}
