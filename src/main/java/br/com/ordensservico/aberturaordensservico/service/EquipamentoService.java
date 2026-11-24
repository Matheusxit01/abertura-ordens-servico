package br.com.ordensservico.aberturaordensservico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ordensservico.aberturaordensservico.dto.EquipamentoRequest;
import br.com.ordensservico.aberturaordensservico.model.Equipamento;
import br.com.ordensservico.aberturaordensservico.model.Setor;
import br.com.ordensservico.aberturaordensservico.repository.EquipamentoRepository;
import br.com.ordensservico.aberturaordensservico.repository.SetorRepository;

@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;
    private final SetorRepository setorRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository, SetorRepository setorRepository) {
        this.equipamentoRepository = equipamentoRepository;
        this.setorRepository = setorRepository;
    }

    public Optional<Equipamento> cadastrar(EquipamentoRequest request) {
        Optional<Setor> setor = setorRepository.findById(request.getSetorId());
        if (setor.isEmpty()) {
            return Optional.empty();
        }
        Equipamento equipamento = new Equipamento();
        equipamento.setNome(request.getNome());
        equipamento.setNumeroPatrimonio(request.getNumeroPatrimonio());
        equipamento.setSetor(setor.get());
        return Optional.of(equipamentoRepository.save(equipamento));
    }

    public List<Equipamento> listar() {
        return equipamentoRepository.findAll();
    }

    public Optional<Equipamento> buscarPorId(int id) {
        return equipamentoRepository.findById(id);
    }

    public Optional<Equipamento> atualizar(int id, EquipamentoRequest request) {
        Optional<Equipamento> existente = equipamentoRepository.findById(id);
        Optional<Setor> setor = setorRepository.findById(request.getSetorId());
        if (existente.isEmpty() || setor.isEmpty()) {
            return Optional.empty();
        }
        Equipamento equipamento = existente.get();
        equipamento.setNome(request.getNome());
        equipamento.setNumeroPatrimonio(request.getNumeroPatrimonio());
        equipamento.setSetor(setor.get());
        return Optional.of(equipamentoRepository.save(equipamento));
    }

    public boolean excluir(int id) {
        if (!equipamentoRepository.existsById(id)) {
            return false;
        }
        equipamentoRepository.deleteById(id);
        return true;
    }
}
