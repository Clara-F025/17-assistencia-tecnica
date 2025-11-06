package br.fiap.assistencia_tecnica.repository;

import br.fiap.assistencia_tecnica.domain.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipamentoRepository extends JpaRepository <Equipamento, Long> {


    List<Equipamento> findByClienteId(Long id);
}
