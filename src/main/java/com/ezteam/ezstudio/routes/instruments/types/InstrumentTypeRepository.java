package com.ezteam.ezstudio.routes.instruments.types;

import com.ezteam.ezstudio.abstractions.data.AbstractRepository;
import org.springframework.stereotype.Repository;

/**
 * @file AbstractRepository.java
 * @description Abstraction for Spring Repository pattern, easier to redefine
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
@Repository
public interface InstrumentTypeRepository extends AbstractRepository<InstrumentTypeEntity> {
}
