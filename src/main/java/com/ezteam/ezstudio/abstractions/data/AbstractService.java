package com.ezteam.ezstudio.abstractions.data;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @file AbstractService.java
 * @description Abstraction for Service pattern that defines the actions that objects will use for CRUD treatments
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AbstractService<Adapter extends AbstractAdapter, Entity extends AbstractEntity, DTO extends AbstractDTO> {

    private AbstractRepository<Entity> repository;

    @Transactional(readOnly = true)
    public List<DTO> getAll() {
        List<Entity> results = repository.findAll();
        List<DTO> objects = convertEntityListToDtoList(results);
        return objects;
    }

    @Transactional(readOnly = true)
    public DTO findById(Long id) {
        if(id == null) {
            return null;
        }
        Entity entity = repository.findOne(id);
        DTO result = (DTO) Adapter.toDto(entity);
        return result;
    }

    @Transactional
    public DTO create(DTO dto) {
        Entity entity = (Entity) Adapter.toEntity(dto);
        repository.save(entity);
        DTO persistedAccount = (DTO) Adapter.toDto(entity);
        return persistedAccount;
    }

    @Transactional
    public DTO deleteById(Long id) {
        DTO result = findById(id);
        if(result != null) {
            repository.delete(id);
        }
        return result;
    }

    @Transactional
    public DTO updateById(Long id, DTO newEntity) {
        DTO oldEntity = findById(id);

        if(oldEntity != null) {
            newEntity.setId(oldEntity.getId());
            newEntity = create(newEntity);
        }
        else {
            newEntity = null;
        }
        return newEntity;
    }

    protected List<DTO> convertEntityListToDtoList(List<Entity> entities) {
        return entities != null ? entities.stream().map(Adapter::toDto).map(object -> (DTO) object).collect(toList()) : null;
    }
}
