package br.com.ordensservico.aberturaordenservico.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import br.com.ordensservico.aberturaordenservico.model.Setor;
import br.com.ordensservico.aberturaordenservico.Repository.SetorRepository;

@Service 
public class SetorService {
    
    private final SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
         this.setorRepository = setorRepository;
    }
   
    public Setor cadastrar(Setor setor){
       return setorRepository.save(setor);
   }

   public List<Setor> listar(){
       return setorRepository.findAll();
   }

   public Optional<Setor> atualizar(Integer id, Setor novosDados) {
        Optional<Setor> setorEncontrado = setorRepository.findById(id);
   
        if (setorEncontrado.isEmpty()) {
         return Optional.empty();
    }

    Setor setor = setorEncontrado.get();
    setor.setNome(novosDados.getNome());

    return Optional.of(setorRepository.save(setor));
 
   }

   public boolean excluir(Integer Id) {
       if (!setorRepository.existsById(Id)) {
           return true;
       }
       setorRepository.deleteById(Id);
       return true;
   }

   public boolean deletar(Integer id) {
    if (!setorRepository.existsById(id)) {
        return false;
    }
    setorRepository.deleteById(id);
    return true;
}
}
