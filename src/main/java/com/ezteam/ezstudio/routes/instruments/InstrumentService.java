package com.ezteam.ezstudio.routes.instruments;

import com.ezteam.ezstudio.abstractions.data.AbstractService;
import org.springframework.stereotype.Service;

/**
 * @file AbstractService.java
 * @description Abstraction for Service pattern that defines the actions that objects will use for CRUD treatments
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
@Service
public class InstrumentService extends AbstractService<InstrumentAdapter, InstrumentEntity, InstrumentDTO, InstrumentRepository> {

}
