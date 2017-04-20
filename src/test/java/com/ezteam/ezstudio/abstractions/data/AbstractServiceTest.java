package com.ezteam.ezstudio.abstractions.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Aurelien
 * @file AbstractServiceTest
 * @description
 * @package com.ezteam.ezstudio.abstractions.data
 * @date 18-Mar-17
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(AbstractAdapter.class)
public class AbstractServiceTest {

    @InjectMocks AbstractService service;

    @Mock AbstractRepository repository;
    @Mock AbstractAdapter adapter;

    private static final Long DEFAULT_ID = 1l;
    private static final AbstractEntity DEFAULT_ENTITY = new AbstractEntity();
    private static final AbstractDTO DEFAULT_DTO = new AbstractDTO();
    private static final List<AbstractEntity> DEFAULT_ENTITY_LIST = Arrays.asList(DEFAULT_ENTITY, DEFAULT_ENTITY, DEFAULT_ENTITY);
    private static final List<AbstractDTO> DEFAULT_DTO_LIST = Arrays.asList(DEFAULT_DTO, DEFAULT_DTO, DEFAULT_DTO);

    @Test
    public void shouldReturnAll() {
        Mockito.doReturn(DEFAULT_ENTITY_LIST).when(repository).findAll();
        Mockito.doReturn(DEFAULT_DTO).when(adapter).toDto(DEFAULT_ENTITY);
        Mockito.doReturn(DEFAULT_ENTITY).when(adapter).toEntity(DEFAULT_DTO);
        List<AbstractDTO> result = service.getAll();

        assertThat(result).isEqualTo(DEFAULT_DTO_LIST);
    }

    @Test
    public void shouldFindById() {
        Mockito.doReturn(DEFAULT_ENTITY).when(repository).findOne(DEFAULT_ID);
        Mockito.doReturn(DEFAULT_DTO).when(adapter).toDto(DEFAULT_ENTITY);
        Mockito.doReturn(DEFAULT_ENTITY).when(adapter).toEntity(DEFAULT_DTO);
        AbstractDTO result = service.findById(DEFAULT_ID);

        assertThat(result).isEqualTo(DEFAULT_DTO);
    }

    @Test
    public void shouldBeNullWhenSearchingWithNullId() {
        AbstractDTO result = service.deleteById(null);

        assertThat(result).isEqualTo(null);
    }

    @Test
    public void shouldBeNullWhenNotFoundById() {
        Mockito.doReturn(null).when(repository).findOne(DEFAULT_ID);
        Mockito.doReturn(null).when(adapter).toDto((AbstractEntity) null);
        Mockito.doReturn(null).when(adapter).toEntity((AbstractDTO) null);
        AbstractDTO result = service.deleteById(DEFAULT_ID);

        assertThat(result).isEqualTo(null);
    }

    @Test
    public void shouldPersist() {
        Mockito.doReturn(DEFAULT_DTO).when(adapter).toDto(DEFAULT_ENTITY);
        Mockito.doReturn(DEFAULT_ENTITY).when(adapter).toEntity(DEFAULT_DTO);
        AbstractDTO result = service.create(DEFAULT_DTO);

        Mockito.verify(repository, Mockito.times(1)).save(DEFAULT_ENTITY);
        assertThat(result).isEqualTo(DEFAULT_DTO);
    }

    @Test
    public void shouldDeleteById() {
        Mockito.doReturn(DEFAULT_ENTITY).when(repository).findOne(DEFAULT_ID);
        Mockito.doReturn(DEFAULT_DTO).when(adapter).toDto(DEFAULT_ENTITY);
        Mockito.doReturn(DEFAULT_ENTITY).when(adapter).toEntity(DEFAULT_DTO);
        AbstractDTO result = service.deleteById(DEFAULT_ID);

        assertThat(result).isEqualTo(DEFAULT_DTO);
    }

    @Test
    public void shouldUpdateById() {
        Mockito.doReturn(DEFAULT_ENTITY).when(repository).findOne(DEFAULT_ID);
        Mockito.doReturn(DEFAULT_DTO).when(adapter).toDto(DEFAULT_ENTITY);
        Mockito.doReturn(DEFAULT_ENTITY).when(adapter).toEntity(DEFAULT_DTO);
        AbstractDTO result = service.updateById(DEFAULT_ID, DEFAULT_DTO);

        Mockito.verify(repository, Mockito.times(1)).findOne(DEFAULT_ID);
        Mockito.verify(repository, Mockito.times(1)).save(DEFAULT_ENTITY);
        assertThat(result).isEqualTo(DEFAULT_DTO);
    }

    @Test
    public void shouldNotPersistAndReturnNullWhenUpdatingNonExistingEntity() {
        Mockito.doReturn(null).when(repository).findOne(DEFAULT_ID);
        Mockito.doReturn(DEFAULT_DTO).when(adapter).toDto(DEFAULT_ENTITY);
        Mockito.doReturn(DEFAULT_ENTITY).when(adapter).toEntity(DEFAULT_DTO);
        AbstractDTO result = service.updateById(DEFAULT_ID, DEFAULT_DTO);

        Mockito.verify(repository, Mockito.times(1)).findOne(DEFAULT_ID);
        Mockito.verify(repository, Mockito.never()).save(DEFAULT_ENTITY);
        assertThat(result).isEqualTo(null);
    }

}