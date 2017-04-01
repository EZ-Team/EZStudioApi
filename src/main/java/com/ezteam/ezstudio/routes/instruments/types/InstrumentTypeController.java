package com.ezteam.ezstudio.routes.instruments.types;

import com.ezteam.ezstudio.abstractions.data.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aurelien on 04-Mar-17.
 */
@RestController
@RequestMapping("/instrumentTypes")
public class InstrumentTypeController extends AbstractController<InstrumentTypeDTO, InstrumentTypeService>{

}
