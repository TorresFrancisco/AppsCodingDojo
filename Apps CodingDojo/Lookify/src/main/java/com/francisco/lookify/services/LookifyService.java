package com.francisco.lookify.services;

import com.francisco.lookify.models.Lookify;
import com.francisco.lookify.repository.LookifyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LookifyService {

    private final LookifyRepository lookifyRepository;

    public LookifyService(LookifyRepository lookifyRepository){
        this.lookifyRepository = lookifyRepository;
    }
    public List<Lookify> allLookifys() {
        return lookifyRepository.findAll();
    }
    public Lookify createLookify(Lookify b) {
        return lookifyRepository.save(b);
    }
    public Lookify findLookify(Long id) {
        Optional<Lookify> optionalLookify = lookifyRepository.findById(id);
        if(optionalLookify.isPresent()){
            return optionalLookify.get();
        } else {
            return null;
        }
    }
    public void deleteLookify(Long id){
        lookifyRepository.deleteById(id);
    }
    public List<Lookify> topTen(){
        return lookifyRepository.findTop10ByOrderByRatingDesc();
    }
    public List<Lookify> artist(String artist){
        return lookifyRepository.findByArtistContaining(artist);
    }
}
