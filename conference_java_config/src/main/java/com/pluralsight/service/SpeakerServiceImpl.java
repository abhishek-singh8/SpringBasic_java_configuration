package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements com.pluralsight.service.SpeakerService {



   /* This is the pain point where we have to manually create an object of repo class and we have hardcoded the reference of
     HibernateSpeakerRepositoryImpl object, if we make any changes we need to rebuild the entire application .
     We should reduce Configuration code from our application cause configuration code is brittle (hard to move to diff env)
     */

    /*   WITHOUT SPRING
    private SpeakerRepository speakerRepository = new HibernateSpeakerRepositoryImpl();
    */

    private SpeakerRepository speakerRepository;


    // For constructor injection
    public SpeakerServiceImpl(SpeakerRepository speakerRepository){
         this.speakerRepository=speakerRepository;
    }

    //We create this setter so that when we create bean of service class at that time only we can inject the bean of repo class.
    public void setSpeakerRepository(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    public List<Speaker> findAll(){
        return speakerRepository.findAll();
    }
}
