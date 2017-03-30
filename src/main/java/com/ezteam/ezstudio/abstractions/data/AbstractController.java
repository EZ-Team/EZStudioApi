package com.ezteam.ezstudio.abstractions.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by a70850 on 27/03/2017.
 */
public class AbstractController<DTO extends AbstractDTO,
                                    Service extends AbstractService> {

    @Autowired
    protected Service service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DTO create(@RequestBody @Valid DTO dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new InvalidException();
        }
        return (DTO) service.create(dto);
    }

    @GetMapping
    public List<DTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DTO getById(@PathVariable("id") Long id) {
        DTO dto = (DTO) service.findById(id);
        if (dto == null) {
            throw new NotFoundException();
        }
        return dto;
    }

    @PutMapping("/{id}")
    public DTO updateById(@PathVariable("id") Long id, @RequestBody @Valid DTO newEntity, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new InvalidException();
        }
        return (DTO) service.updateById(id, newEntity);
    }

    @DeleteMapping("/{id}")
    public DTO deleteById(@PathVariable("id") Long id) {
        DTO dto = (DTO) service.deleteById(id);
        if (dto == null) {
            throw new NotFoundException();
        }
        return dto;
    }
}
