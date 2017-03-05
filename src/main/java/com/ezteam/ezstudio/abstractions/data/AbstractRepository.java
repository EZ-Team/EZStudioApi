package com.ezteam.ezstudio.abstractions.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @file AbstractRepository.java
 * @description Abstraction for Spring Repository pattern, easier to redefine
 * @package com.ezteam.ezstudio
 * @date 04-Mar-2017
 * @author ACID-KILLA666 <aurelien.duval6@gmail.com>
 */
@NoRepositoryBean
public interface AbstractRepository<T> extends JpaRepository<T, Long> {
}
