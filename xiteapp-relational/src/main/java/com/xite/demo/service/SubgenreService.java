package com.xite.demo.service;

import com.xite.demo.model.Subgenre;
import com.xite.demo.repository.SubgenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubgenreService implements ISubgenreService{

    @Autowired
    SubgenreRepository subgenreRepository = null;

    @Override
    public Subgenre findByName(String name) {
        Optional<Subgenre> subgenre = subgenreRepository.findByName(name);

        if (!subgenre.isPresent())
            throw new RuntimeException("name" + name);

        return subgenre.get();
    }
}
