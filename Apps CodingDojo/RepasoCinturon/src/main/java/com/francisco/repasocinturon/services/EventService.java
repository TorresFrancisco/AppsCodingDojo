package com.francisco.repasocinturon.services;

import com.francisco.repasocinturon.models.Event;
import com.francisco.repasocinturon.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventService extends BaseService<Event> {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository){
        super(eventRepository);
        this.eventRepository = eventRepository;
    }


    public List<Event> findByState(String state) {//(T) es lo que tu desees
        return eventRepository.findByStateContaining(state);
    }
    public List<Event> findByStateNot(String state) {//(T) es lo que tu desees
        return eventRepository.findByStateNotContaining(state);
    }
}
