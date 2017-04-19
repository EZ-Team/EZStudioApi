package com.ezteam.ezstudio.abstractions.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by a70850 on 28/03/2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Slf4j
public class AbstractService<Adapter extends AbstractAdapter, Entity extends AbstractEntity, DTO extends AbstractDTO, Repository extends AbstractRepository> {

    @Autowired
    protected Repository repository;

    @Autowired
    protected Adapter adapter;

    @Transactional(readOnly = true)
    public List<DTO> getAll() {
        List<Entity> results = repository.findAll();
        List<DTO> objects = convertEntityListToDtoList(results);
        return objects;
    }

    @Transactional(readOnly = true)
    public DTO findById(Long id) {
        if(id == null) {
            log.warn("Given id was null");
            return null;
        }
        Entity entity = (Entity) repository.findOne(id);
        DTO result = (DTO) adapter.toDto(entity);
        return result;
    }

    @Transactional
    public DTO create(DTO dto) {
        Entity entity = (Entity) adapter.toEntity(dto);
        repository.save(entity);
        DTO persistedAccount = (DTO) adapter.toDto(entity);
        return persistedAccount;
    }

    @Transactional
    public DTO deleteById(Long id) {
        DTO result = findById(id);
        if(result != null) {
            log.info("Found an element, deleting it");
            repository.delete(id);
        }
        return result;
    }

    @Transactional
    public DTO updateById(Long id, DTO newEntity) {
        DTO oldEntity = findById(id);

        if(oldEntity != null) {
            log.debug("Entity exists : {}", oldEntity);
            newEntity.setId(oldEntity.getId());
            newEntity = create(newEntity);
        }
        else {
            newEntity = null;
        }
        return newEntity;
    }

    protected List<DTO> convertEntityListToDtoList(List<Entity> entities) {
        return entities != null ? entities.stream().map(adapter::toDto).map(object -> (DTO) object).collect(toList()) : null;
    }
}
