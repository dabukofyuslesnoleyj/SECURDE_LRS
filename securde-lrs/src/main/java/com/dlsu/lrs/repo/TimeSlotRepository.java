package com.dlsu.lrs.repo;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.TimeSlot;

public interface TimeSlotRepository extends CrudRepository<TimeSlot, String> {
}
