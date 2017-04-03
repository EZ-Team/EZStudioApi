package com.ezteam.ezstudio.routes.instruments;

import com.ezteam.ezstudio.abstractions.data.AbstractDomain;
import com.ezteam.ezstudio.routes.instruments.types.InstrumentType;
import lombok.Builder;
import lombok.Data;

/**
 * Created by aurelien on 01/04/17.
 */
@Data
@Builder
public class Instrument extends AbstractDomain {

    private String name;

    private InstrumentType category;
}
