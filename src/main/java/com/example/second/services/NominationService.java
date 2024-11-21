package com.example.second.services;

import com.example.second.configuration.RibbonClientConfig;
import com.example.second.model.Nomination;
import com.example.second.repositories.NominationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Service;


@Service
//@RibbonClient(name = "basic", configuration = RibbonClientConfig.class)
public class NominationService {
    @Autowired
    private NominationRepository nominationRepository;

    public Nomination createNomination(Nomination nomination) {
        return nominationRepository.save(nomination);
    }
}
