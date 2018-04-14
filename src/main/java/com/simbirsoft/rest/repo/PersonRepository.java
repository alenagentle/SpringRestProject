package com.simbirsoft.rest.repo;

import com.simbirsoft.rest.dto.PersonDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonDto, Long> {
    public List<PersonDto> findPersonById(Long id);
}
