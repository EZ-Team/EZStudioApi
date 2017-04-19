package com.ezteam.ezstudio.routes.instruments;

import com.ezteam.ezstudio.abstractions.data.AbstractAdapter;
import com.ezteam.ezstudio.abstractions.data.AbstractDTO;
import com.ezteam.ezstudio.abstractions.data.AbstractDomain;
import com.ezteam.ezstudio.abstractions.data.AbstractEntity;
import com.ezteam.ezstudio.routes.instruments.types.InstrumentType;
import com.ezteam.ezstudio.routes.instruments.types.InstrumentTypeAdapter;
import com.ezteam.ezstudio.routes.instruments.types.InstrumentTypeAdapter;
import com.ezteam.ezstudio.routes.instruments.types.InstrumentTypeDTO;
import com.ezteam.ezstudio.routes.instruments.types.InstrumentTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @file AbstractAdapter.java
 * @description Abstraction for Adapter pattern for DTO/Entity conversion
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
@Service
public class InstrumentAdapter extends AbstractAdapter {

    private static InstrumentTypeAdapter instrumentTypeAdapter = new InstrumentTypeAdapter();

    @Override
    protected AbstractEntity callEntityBuilder(AbstractDTO dto) {
        InstrumentDTO curr = (InstrumentDTO) dto;
        return InstrumentEntity.builder()
                .id(curr.getId())
                .name(curr.getName())
                .category((InstrumentTypeEntity) instrumentTypeAdapter.toEntity(curr.getCategory()))
                .build();
    }
    @Override
    protected AbstractEntity callEntityBuilder(AbstractDomain domain) {
        Instrument curr = (Instrument) domain;
        return InstrumentEntity.builder()
                .name(curr.getName())
                .category((InstrumentTypeEntity) instrumentTypeAdapter.toEntity(curr.getCategory()))
                .build();
    }

    @Override
    protected AbstractDTO callDtoBuilder(AbstractEntity entity) {
        InstrumentEntity curr = (InstrumentEntity) entity;
        return InstrumentDTO.builder()
                .id(curr.getId())
                .name(curr.getName())
                .category((InstrumentTypeDTO) instrumentTypeAdapter.toDto(curr.getCategory()))
                .build();
    }
    @Override
    protected AbstractDTO callDtoBuilder(AbstractDomain domain) {
        Instrument curr = (Instrument) domain;
        return InstrumentDTO.builder()
                .name(curr.getName())
                .category((InstrumentTypeDTO) instrumentTypeAdapter.toDto(curr.getCategory()))
                .build();
    }

    @Override
    protected AbstractDomain callDomainBuilder(AbstractEntity entity) {
        InstrumentEntity curr = (InstrumentEntity) entity;
        return Instrument.builder()
                .name(curr.getName())
                .category((InstrumentType) instrumentTypeAdapter.toDomain(curr.getCategory()))
                .build();
    }
    @Override
    protected AbstractDomain callDomainBuilder(AbstractDTO dto) {
        InstrumentDTO curr = (InstrumentDTO) dto;
        return Instrument.builder()
                .name(curr.getName())
                .category((InstrumentType) instrumentTypeAdapter.toDomain(curr.getCategory()))
                .build();
    }
}
