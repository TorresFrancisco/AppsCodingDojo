package com.francisco.dojosninjas.services;

import com.francisco.dojosninjas.models.Ninja;
import com.francisco.dojosninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    public Ninja createNinja(Ninja b) {
        return ninjaRepository.save(b);
    }
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()){
            return optionalNinja.get();
        } else {
            return null;
        }
    }
}
