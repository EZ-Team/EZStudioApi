package com.ezteam.ezstudio.abstractions.data;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Aurelien on 04-Mar-17.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AbstractController<Adapter extends AbstractAdapter, Entity extends AbstractEntity, DTO extends AbstractDTO> {

    @NonNull protected AbstractService<Adapter, Entity, DTO> service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DTO create(@RequestBody @Valid DTO dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new InvalidException();
        }
        return service.create(dto);
    }

    @GetMapping
    public List<DTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DTO getById(@PathVariable("id") Long id) {
        DTO dto = service.findById(id);
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
        return service.updateById(id, newEntity);
    }

    @DeleteMapping("/{id}")
    public DTO deleteById(@PathVariable("id") Long id) {
        DTO dto = service.deleteById(id);
        if (dto == null) {
            throw new NotFoundException();
        }
        return dto;
    }
}
