package br.com.ordensservico.aberturaordensservico.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ordensservico.aberturaordensservico.dto.OrdemServicoRequest;
import br.com.ordensservico.aberturaordensservico.model.Equipamento;
import br.com.ordensservico.aberturaordensservico.model.OrdemServico;
import br.com.ordensservico.aberturaordensservico.repository.EquipamentoRepository;
import br.com.ordensservico.aberturaordensservico.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final EquipamentoRepository equipamentoRepository;

    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository,
                               EquipamentoRepository equipamentoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public Optional<OrdemServico> cadastrar(OrdemServicoRequest request) {
        Optional<Equipamento> equipamento = equipamentoRepository.findById(request.getEquipamentoId());
        if (equipamento.isEmpty()) {
            return Optional.empty();
        }
        OrdemServico ordem = new OrdemServico();
        ordem.setDescricao(request.getDescricao());
        ordem.setEquipamento(equipamento.get());
        ordem.setDataAbertura(LocalDateTime.now());
        return Optional.of(ordemServicoRepository.save(ordem));
    }

    public List<OrdemServico> listar() {
        return ordemServicoRepository.findAll();
    }

    public Optional<OrdemServico> buscarPorId(int id) {
        return ordemServicoRepository.findById(id);
    }
}
