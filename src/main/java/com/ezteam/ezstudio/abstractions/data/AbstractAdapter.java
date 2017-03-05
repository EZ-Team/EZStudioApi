package com.ezteam.ezstudio.abstractions.data;

/**
 * @file AbstractAdapter.java
 * @description Abstraction for Adapter pattern for DTO/Entity conversion
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
public abstract class AbstractAdapter {

    public static AbstractEntity toEntity(AbstractDTO dto) {
        return dto != null ? callEntityBuilder(dto) : null;
    }

    public static AbstractDTO toDto(AbstractEntity entity){
        return entity != null ? callDtoBuilder(entity) : null;
    }

    protected static AbstractEntity callEntityBuilder(AbstractDTO dto) {
        return null;
    }

    protected static AbstractDTO callDtoBuilder(AbstractEntity entity) {
        return null;
    }

}
