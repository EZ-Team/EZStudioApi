package com.ezteam.ezstudio.routes.instruments;

import com.ezteam.ezstudio.abstractions.data.AbstractDTO;
import com.ezteam.ezstudio.routes.instruments.types.InstrumentTypeDTO;
import com.ezteam.ezstudio.routes.instruments.types.InstrumentTypeEntity;
import lombok.*;

/**
 * @file AbstractDTO.java
 * @description Abstraction for DTO (Data Transfer Object) pattern that defines objects in Java runtime context
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
@Data
@Builder
public class InstrumentDTO extends AbstractDTO {

    private Long id;

    private String name;

    private InstrumentTypeDTO category;
}
