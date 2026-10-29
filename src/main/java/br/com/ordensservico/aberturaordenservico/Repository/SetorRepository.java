package br.com.ordensservico.aberturaordenservico.Repository;

import br.com.ordensservico.aberturaordenservico.model.Setor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SetorRepository 
 extends JpaRepository<Setor, Integer> {

}
