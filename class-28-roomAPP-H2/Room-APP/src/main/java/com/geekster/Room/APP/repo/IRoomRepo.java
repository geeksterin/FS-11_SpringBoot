package com.geekster.Room.APP.repo;

import com.geekster.Room.APP.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRoomRepo extends CrudRepository<Room,Integer> {
}
