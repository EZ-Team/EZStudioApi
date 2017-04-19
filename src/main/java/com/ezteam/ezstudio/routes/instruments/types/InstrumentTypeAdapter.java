package com.ezteam.ezstudio.routes.instruments.types;

import com.ezteam.ezstudio.abstractions.data.AbstractAdapter;
import com.ezteam.ezstudio.abstractions.data.AbstractDTO;
import com.ezteam.ezstudio.abstractions.data.AbstractDomain;
import com.ezteam.ezstudio.abstractions.data.AbstractEntity;
import org.springframework.stereotype.Service;

/**
 * @file AbstractAdapter.java
 * @description Abstraction for Adapter pattern for DTO/Entity conversion
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
@Service
public class InstrumentTypeAdapter extends AbstractAdapter {
    @Override
    protected AbstractEntity callEntityBuilder(AbstractDTO dto) {
        InstrumentTypeDTO curr = (InstrumentTypeDTO) dto;
        return InstrumentTypeEntity.builder()
                .id(curr.getId())
                .name(curr.getName())
                .build();
    }
    @Override
    protected AbstractEntity callEntityBuilder(AbstractDomain domain) {
        InstrumentType curr = (InstrumentType) domain;
        return InstrumentTypeEntity.builder()
                .name(curr.getName())
                .build();
    }

    @Override
    protected AbstractDTO callDtoBuilder(AbstractEntity entity) {
        InstrumentTypeEntity curr = (InstrumentTypeEntity) entity;
        return InstrumentTypeDTO.builder()
                .id(curr.getId())
                .name(curr.getName())
                .build();
    }
    @Override
    protected AbstractDTO callDtoBuilder(AbstractDomain domain) {
        InstrumentType curr = (InstrumentType) domain;
        return InstrumentTypeDTO.builder()
                .name(curr.getName())
                .build();
    }

    @Override
    protected AbstractDomain callDomainBuilder(AbstractEntity entity) {
        InstrumentTypeEntity curr = (InstrumentTypeEntity) entity;
        return InstrumentType.builder()
                .name(curr.getName())
                .build();
    }
    @Override
    protected AbstractDomain callDomainBuilder(AbstractDTO dto) {
        InstrumentTypeDTO curr = (InstrumentTypeDTO) dto;
        return InstrumentType.builder()
                .name(curr.getName())
                .build();
    }
}
