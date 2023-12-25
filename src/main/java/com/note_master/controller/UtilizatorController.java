package com.note_master.controller;

import com.note_master.entity.Utilizator;
import com.note_master.service.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilizator")
public class UtilizatorController {

    @Autowired
    private UtilizatorService utilizatorService;

    @GetMapping
    public List<Utilizator> getAllUtilizatori() {
        return utilizatorService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Utilizator getUtilizatorById(@PathVariable Long id) {
        return utilizatorService.getUserById(id);
    }

    @PostMapping("/create_utilizator")
    public Utilizator createUtilizator(@RequestBody Utilizator utilizator) {
        System.out.println("DEBUG: crreate_utilizator ; Controller");
        return utilizatorService.createUser(utilizator);
    }



    @PostMapping("/login")
    public Utilizator loginUtilizator(@RequestBody Utilizator utilizator) {
        System.out.println("DEBUG: loginUtilizator ; Controller");

        return utilizatorService.loginUtilizator(utilizator);
    }


    @PutMapping("/{id}")
    public Utilizator updateUtilizator(@PathVariable Long id, @RequestBody Utilizator utilizator) {
        return utilizatorService.updateUtilizator(id, utilizator);
    }
    public void deleteUtilizator(@PathVariable int id) {
        utilizatorService.deleteUtilizator(id);
    }
}
