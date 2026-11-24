package br.com.ordensservico.aberturaordensservico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ordensservico.aberturaordensservico.model.Setor;
import br.com.ordensservico.aberturaordensservico.repository.SetorRepository;

@Service
public class SetorService {

    private final SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    public Setor cadastrar(Setor setor) {
        return setorRepository.save(setor);
    }

    public List<Setor> listar() {
        return setorRepository.findAll();
    }

    public Optional<Setor> buscarPorId(int id) {
        return setorRepository.findById(id);
    }

    public Optional<Setor> atualizar(int id, Setor dados) {
        Optional<Setor> existente = setorRepository.findById(id);
        if (existente.isEmpty()) {
            return Optional.empty();
        }
        Setor setor = existente.get();
        setor.setNome(dados.getNome());
        return Optional.of(setorRepository.save(setor));
    }

    public boolean excluir(int id) {
        if (!setorRepository.existsById(id)) {
            return false;
        }
        setorRepository.deleteById(id);
        return true;
    }
}
