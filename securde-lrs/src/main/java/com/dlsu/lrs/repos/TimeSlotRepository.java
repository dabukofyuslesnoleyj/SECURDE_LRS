package com.dlsu.lrs.repos;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.TimeSlot;

public interface TimeSlotRepository extends CrudRepository<TimeSlot, String> {
}
