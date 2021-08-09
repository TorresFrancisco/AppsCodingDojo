package com.francisco.dojooverflow.services;

import com.francisco.dojooverflow.models.Tag;
import com.francisco.dojooverflow.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }

    public List<Tag> allTags() {
        return tagRepository.findAll();
    }

    public Tag createTag(Tag c) {
        return tagRepository.save(c);
    }

    public Tag findTag(String subject) {
        Optional<Tag> optionalTag = tagRepository.findBySubject(subject);
        if(optionalTag.isPresent()){
            return optionalTag.get();
        } else {
            return null;
        }
    }
}
