package com.SpringBoot_API_ControleFinanceiro.Controller;

import com.SpringBoot_API_ControleFinanceiro.Entity.Grupo;
import com.SpringBoot_API_ControleFinanceiro.Service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/grupo")
public class GrupoController {
    @Autowired
    private GrupoService grupoService;

    @GetMapping
    public List<Grupo> finAll() {
        return grupoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Grupo findById(@PathVariable Integer id) {
        return this.grupoService.findById(id);
    }

    @PostMapping
    public Grupo save(@RequestBody Grupo grupo) {
        return this.grupoService.save(grupo);
    }

    @PutMapping
    public Grupo update(@RequestBody Grupo grupo) {
        return this.grupoService.update(grupo);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id) {
        this.grupoService.delete(id);
    }
}
