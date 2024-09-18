package com.SpringBoot_API_ControleFinanceiro.Controller;

import com.SpringBoot_API_ControleFinanceiro.Entity.Meta;
import com.SpringBoot_API_ControleFinanceiro.Service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/meta")
public class MetaController {
    @Autowired
    private MetaService metaService;

    @GetMapping
    public List<Meta> finAll() {
        return metaService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Meta findById(@PathVariable Integer id) {
        return this.metaService.findById(id);
    }

    @PostMapping
    public Meta save(@RequestBody Meta meta) {
        return this.metaService.save(meta);
    }

    @PutMapping
    public Meta update(@RequestBody Meta meta) {
        return this.metaService.update(meta);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id) {
        this.metaService.delete(id);
    }
}
