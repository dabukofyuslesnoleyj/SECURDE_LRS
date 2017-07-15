package com.dlsu.lrs.repo;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.Room;

public interface RoomRepository extends CrudRepository<Room, String> {
}
