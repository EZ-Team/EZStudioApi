package com.ezteam.ezstudio.abstractions.data;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Aurelien on 04-Mar-17.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class AbstractController<Adapter extends AbstractAdapter, Entity extends AbstractEntity, DTO extends AbstractDTO> {

    @NonNull protected AbstractService<Adapter, Entity, DTO> service;

    public DTO create(DTO dto) {
        return service.create(dto);
    }

    public List<DTO> getAll() {
        return service.getAll();
    }

    public DTO getById(Long id) {
        return service.findById(id);
    }

    public DTO updateById(Long id, DTO newEntity) {
        return service.updateById(id, newEntity);
    }

    public DTO deleteById(Long id) {
        return service.deleteById(id);
    }
}
