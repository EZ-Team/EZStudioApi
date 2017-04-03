package com.ezteam.ezstudio.routes.instruments.types;

import com.ezteam.ezstudio.abstractions.data.AbstractDomain;
import lombok.Builder;
import lombok.Data;

/**
 * Created by aurelien on 01/04/17.
 */
@Data
@Builder
public class InstrumentType extends AbstractDomain {

    private String name;
}
