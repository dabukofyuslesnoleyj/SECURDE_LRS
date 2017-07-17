package com.dlsu.lrs.repos;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.RoomReservation;

public interface RoomReservationRepository extends CrudRepository<RoomReservation, Long> {
}
