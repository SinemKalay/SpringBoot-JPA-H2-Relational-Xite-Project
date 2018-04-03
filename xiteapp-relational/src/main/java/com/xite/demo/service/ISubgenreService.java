package com.xite.demo.service;

import com.xite.demo.model.Subgenre;
import com.xite.demo.repository.SubgenreRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface ISubgenreService {

    @Autowired
    SubgenreRepository subgenreRepository = null;

    Subgenre findByName(String name);
}
