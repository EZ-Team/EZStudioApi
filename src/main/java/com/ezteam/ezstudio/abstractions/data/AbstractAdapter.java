package com.ezteam.ezstudio.abstractions.data;

/**
 * @file AbstractAdapter.java
 * @description Abstraction for Adapter pattern for DTO/Entity conversion
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
public class AbstractAdapter {

    public static AbstractEntity toEntity(AbstractDTO dto) {
        return dto != null ? callEntityBuilder(dto) : null;
    }
    public static AbstractEntity toEntity(AbstractDomain domain){
        return domain != null ? callEntityBuilder(domain) : null;
    }

    public static AbstractDTO toDto(AbstractEntity entity){
        return entity != null ? callDtoBuilder(entity) : null;
    }
    public static AbstractDTO toDto(AbstractDomain domain){
        return domain != null ? callDtoBuilder(domain) : null;
    }

    public static AbstractDomain toDomain(AbstractEntity entity){
        return entity != null ? callDomainBuilder(entity) : null;
    }
    public static AbstractDomain toDomain(AbstractDTO dto){
        return dto != null ? callDomainBuilder(dto) : null;
    }

    protected static AbstractEntity callEntityBuilder(AbstractDTO dto) {
        return null;
    }
    protected static AbstractEntity callEntityBuilder(AbstractDomain domain) {
        return null;
    }

    protected static AbstractDTO callDtoBuilder(AbstractEntity entity) {
        return null;
    }
    protected static AbstractDTO callDtoBuilder(AbstractDomain domain) {
        return null;
    }

    protected static AbstractDomain callDomainBuilder(AbstractEntity entity) {
        return null;
    }
    protected static AbstractDomain callDomainBuilder(AbstractDTO dto) {
        return null;
    }

}
