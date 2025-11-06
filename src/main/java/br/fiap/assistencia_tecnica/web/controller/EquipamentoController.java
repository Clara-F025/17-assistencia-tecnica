package br.fiap.assistencia_tecnica.web.controller;

import br.fiap.assistencia_tecnica.domain.Equipamento;
import br.fiap.assistencia_tecnica.service.EquipamentoService;
import br.fiap.assistencia_tecnica.web.dto.EquipamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoService service;

    @GetMapping("/listar")
    public List<Equipamento> listar() {
        return service.listar();
    }

    @PostMapping
    public Equipamento cadastrar(EquipamentoDTO equipamentoDTO) {
        return service.cadastrar(equipamentoDTO);
    }

    @GetMapping("/listar/{idCliente}")
    public List<Equipamento> listarPorCliente(@PathVariable Long idCliente){
        return service.listarPorCliente(idCliente);
    }
}
