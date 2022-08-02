package ru.netology.DAOapp_hibernate.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.DAOapp_hibernate.service.AppService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/")
public class AppController {
    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/persons/by-city")
    public List getPersonsByCity(@PathParam("city") String city) {
        return appService.getPersonsByCity(city);
    }
}