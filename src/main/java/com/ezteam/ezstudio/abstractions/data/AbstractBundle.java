package com.ezteam.ezstudio.abstractions.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @file AbstractBundle.java
 * @description Abstraction for a custom bundle which will instantiate and orchestrate all CRUD treatments over data objects
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class AbstractBundle {
    protected AbstractAdapter adapter;
    protected AbstractDTO dto;
    protected AbstractEntity entity;
    protected AbstractService service;
}
