package ru.netology.DAOapp_hibernate.service;

import org.springframework.stereotype.Service;
import ru.netology.DAOapp_hibernate.repository.AppRepository;

import java.util.List;

@Service
public class AppService {
    private final AppRepository appRepository;

    public AppService(AppRepository appRepository){
        this.appRepository=appRepository;
    }

    public List getPersonsByCity(String city) {
        return appRepository.getPersonsByCity(city);
    }
}
