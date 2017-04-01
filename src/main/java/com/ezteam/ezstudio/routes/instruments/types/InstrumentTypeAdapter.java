package com.ezteam.ezstudio.routes.instruments.types;

import com.ezteam.ezstudio.abstractions.data.AbstractAdapter;
import com.ezteam.ezstudio.abstractions.data.AbstractDTO;
import com.ezteam.ezstudio.abstractions.data.AbstractDomain;
import com.ezteam.ezstudio.abstractions.data.AbstractEntity;

/**
 * @file AbstractAdapter.java
 * @description Abstraction for Adapter pattern for DTO/Entity conversion
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
public class InstrumentTypeAdapter extends AbstractAdapter {
    protected static AbstractEntity callEntityBuilder(AbstractDTO dto) {
        return null;
    }
    protected static AbstractEntity callEntityBuilder(AbstractDomain domain) {
        return null;
    }

    protected static AbstractDTO callDtoBuilder(AbstractEntity entity) {
        return null;
    }
    protected static AbstractDTO callDtoBuilder(AbstractDomain domain) {
        return null;
    }

    protected static AbstractDomain callDomainBuilder(AbstractEntity entity) {
        return null;
    }
    protected static AbstractDomain callDomainBuilder(AbstractDTO dto) {
        return null;
    }
}
