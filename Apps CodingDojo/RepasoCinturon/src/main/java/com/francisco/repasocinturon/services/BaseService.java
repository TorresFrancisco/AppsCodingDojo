package com.francisco.repasocinturon.services;

import com.francisco.repasocinturon.repository.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseService<T> {
    private final BaseRepository<T> baseRepository;

    public BaseService(BaseRepository<T> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public List<T> allData() {//(T) es lo que tu desees
        return baseRepository.findAll();
    }

    public T createOrUpdate(T entity) {
        return baseRepository.save(entity);
    }

    public T findById(Long id) {
        Optional<T> tOptional = baseRepository.findById(id);
        if(tOptional.isPresent()) {
            return tOptional.get();
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        baseRepository.deleteById(id);
    }
}
