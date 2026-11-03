package br.com.ordensservico.aberturaordenservico.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ordensservico.aberturaordenservico.model.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {
    
}
