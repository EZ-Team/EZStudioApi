package com.ezteam.ezstudio.abstractions.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

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

    private static final Long DEFAULT_ID = 1l;
    private static final AbstractEntity DEFAULT_ENTITY = new AbstractEntity();
    private static final AbstractDTO DEFAULT_DTO = new AbstractDTO();

    @Test
    public void shouldFindById() {
        PowerMockito.spy(AbstractAdapter.class);
        Mockito.doReturn(DEFAULT_ENTITY).when(repository).findOne(DEFAULT_ID);
        BDDMockito.given(AbstractAdapter.toDto(DEFAULT_ENTITY)).willReturn(DEFAULT_DTO);
        AbstractDTO result = service.findById(DEFAULT_ID);

        assertThat(result).isEqualTo(DEFAULT_DTO);
    }

    @Test
    public void shouldThrowWhenNotFoundById() {

    }

    @Test
    public void persist() {

    }

    @Test
    public void deleteById() {

    }

    @Test
    public void updateById() {

    }

}