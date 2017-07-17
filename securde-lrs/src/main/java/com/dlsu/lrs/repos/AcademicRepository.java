package com.dlsu.lrs.repos;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.Academic;

public interface AcademicRepository extends CrudRepository<Academic, String> {
}
