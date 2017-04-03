package com.ezteam.ezstudio.routes.instruments;

import com.ezteam.ezstudio.abstractions.data.AbstractAdapter;
import com.ezteam.ezstudio.abstractions.data.AbstractDTO;
import com.ezteam.ezstudio.abstractions.data.AbstractDomain;
import com.ezteam.ezstudio.abstractions.data.AbstractEntity;
import com.ezteam.ezstudio.routes.instruments.types.InstrumentType;
import com.ezteam.ezstudio.routes.instruments.types.InstrumentTypeAdapter;
import com.ezteam.ezstudio.routes.instruments.types.InstrumentTypeDTO;
import com.ezteam.ezstudio.routes.instruments.types.InstrumentTypeEntity;

/**
 * @file AbstractAdapter.java
 * @description Abstraction for Adapter pattern for DTO/Entity conversion
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
public class InstrumentAdapter extends AbstractAdapter {
    protected static AbstractEntity callEntityBuilder(AbstractDTO dto) {
        InstrumentDTO curr = (InstrumentDTO) dto;
        return InstrumentEntity.builder()
                .id(curr.getId())
                .name(curr.getName())
                .category((InstrumentTypeEntity) InstrumentTypeAdapter.toEntity(curr.getCategory()))
                .build();
    }
    protected static AbstractEntity callEntityBuilder(AbstractDomain domain) {
        Instrument curr = (Instrument) domain;
        return InstrumentEntity.builder()
                .name(curr.getName())
                .category((InstrumentTypeEntity) InstrumentTypeAdapter.toEntity(curr.getCategory()))
                .build();
    }

    protected static AbstractDTO callDtoBuilder(AbstractEntity entity) {
        InstrumentEntity curr = (InstrumentEntity) entity;
        return InstrumentDTO.builder()
                .id(curr.getId())
                .name(curr.getName())
                .category((InstrumentTypeDTO) InstrumentTypeAdapter.toDto(curr.getCategory()))
                .build();
    }
    protected static AbstractDTO callDtoBuilder(AbstractDomain domain) {
        Instrument curr = (Instrument) domain;
        return InstrumentDTO.builder()
                .name(curr.getName())
                .category((InstrumentTypeDTO) InstrumentTypeAdapter.toDto(curr.getCategory()))
                .build();
    }

    protected static AbstractDomain callDomainBuilder(AbstractEntity entity) {
        InstrumentEntity curr = (InstrumentEntity) entity;
        return Instrument.builder()
                .name(curr.getName())
                .category((InstrumentType) InstrumentTypeAdapter.toDomain(curr.getCategory()))
                .build();
    }
    protected static AbstractDomain callDomainBuilder(AbstractDTO dto) {
        InstrumentDTO curr = (InstrumentDTO) dto;
        return Instrument.builder()
                .name(curr.getName())
                .category((InstrumentType) InstrumentTypeAdapter.toDomain(curr.getCategory()))
                .build();
    }
}
