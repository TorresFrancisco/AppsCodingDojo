package com.francisco.repasocinturon.repository;

import com.francisco.repasocinturon.models.Event;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends BaseRepository<Event> {

    List<Event> findByStateContaining(String state);

    List<Event> findByStateNotContaining(String state);

}
