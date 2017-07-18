package com.dlsu.lrs.repo;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.RoomReservation;

public interface RoomReservationRepository extends CrudRepository<RoomReservation, String> {
}
