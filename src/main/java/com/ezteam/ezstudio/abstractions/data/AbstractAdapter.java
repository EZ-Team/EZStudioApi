package com.ezteam.ezstudio.abstractions.data;

import org.springframework.stereotype.Service;

/**
 * @file AbstractAdapter.java
 * @description Abstraction for Adapter pattern for DTO/Entity conversion
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
public class AbstractAdapter {

    public AbstractEntity toEntity(AbstractDTO dto) {
        return dto != null ? callEntityBuilder(dto) : null;
    }
    public AbstractEntity toEntity(AbstractDomain domain){
        return domain != null ? callEntityBuilder(domain) : null;
    }

    public AbstractDTO toDto(AbstractEntity entity){
        return entity != null ? callDtoBuilder(entity) : null;
    }
    public AbstractDTO toDto(AbstractDomain domain){
        return domain != null ? callDtoBuilder(domain) : null;
    }

    public AbstractDomain toDomain(AbstractEntity entity){
        return entity != null ? callDomainBuilder(entity) : null;
    }
    public AbstractDomain toDomain(AbstractDTO dto){
        return dto != null ? callDomainBuilder(dto) : null;
    }

    protected AbstractEntity callEntityBuilder(AbstractDTO dto) {
        return null;
    }
    protected AbstractEntity callEntityBuilder(AbstractDomain domain) {
        return null;
    }

    protected AbstractDTO callDtoBuilder(AbstractEntity entity) {
        return null;
    }
    protected AbstractDTO callDtoBuilder(AbstractDomain domain) {
        return null;
    }

    protected AbstractDomain callDomainBuilder(AbstractEntity entity) {
        return null;
    }
    protected AbstractDomain callDomainBuilder(AbstractDTO dto) {
        return null;
    }

}
