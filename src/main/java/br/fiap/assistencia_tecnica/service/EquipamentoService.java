package br.fiap.assistencia_tecnica.service;

import br.fiap.assistencia_tecnica.domain.Equipamento;
import br.fiap.assistencia_tecnica.repository.ClienteRepository;
import br.fiap.assistencia_tecnica.repository.EquipamentoRepository;
import br.fiap.assistencia_tecnica.web.dto.EquipamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Equipamento> listar() {
        return repository.findAll();
    }

    public Equipamento cadastrar(EquipamentoDTO dto){
        var cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(()-> new NoSuchElementException("Cliente não encontrado"));

         var equipamentoEntity = new Equipamento();
         equipamentoEntity.setCliente(cliente);
         equipamentoEntity.setModelo(dto.getModelo());
         equipamentoEntity.setMarca(dto.getMarca());
         equipamentoEntity.setTipo(dto.getTipo());
         equipamentoEntity.setNumeroSerie(dto.getNumeroSerie());
         equipamentoEntity.setDataCadastro(dto.getDataCadastro());

         return repository.save(equipamentoEntity);
    }

    public List<Equipamento> listarPorCliente(Long id) {

        return repository.findByClienteId(id);
    }
}
