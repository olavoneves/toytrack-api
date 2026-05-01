package br.com.fiap.toytrack.service;

import br.com.fiap.toytrack.model.Brinquedo;
import br.com.fiap.toytrack.repository.BrinquedoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrinquedoService {

    private final BrinquedoRepository brinquedoRepository;

    public BrinquedoService(BrinquedoRepository brinquedobrinquedoRepository) {
        this.brinquedoRepository = brinquedobrinquedoRepository;
    }

    public List<Brinquedo> listarTodos() {
        return brinquedoRepository.findAll();
    }

    public Optional<Brinquedo> buscarPorId(Long id) {
        return brinquedoRepository.findById(id);
    }

    public Brinquedo salvar(Brinquedo brinquedo) {
        return brinquedoRepository.save(brinquedo);
    }

    public Optional<Brinquedo> atualizar(Long id, Brinquedo dadosNovos) {
        return brinquedoRepository
                .findById(id)
                .map(brinquedo -> {
                            brinquedo.setNome(dadosNovos.getNome());
                            brinquedo.setTipo(dadosNovos.getTipo());
                            brinquedo.setClassificacao(dadosNovos.getClassificacao());
                            brinquedo.setTamanho(dadosNovos.getTamanho());
                            brinquedo.setPreco(dadosNovos.getPreco());
            return brinquedoRepository
                    .save(brinquedo);
        });
    }

    public boolean deletar(Long id) {
        if (brinquedoRepository.existsById(id)) {
            brinquedoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
