package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.DadosAtualizarMedico;
import med.voll.api.dto.DadosCadastroMedico;
import med.voll.api.domain.Medico;
import med.voll.api.dto.DadosListagemMedico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {


    @Autowired
    private MedicoRepository repository;
    private DadosListagemMedico listagemMedico;

    @PostMapping
    @Transactional //Medico de escrita então tenho que ter uma transação
    public ResponseEntity<String> cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
        System.out.println(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso!");
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao) {
        paginacao = PageRequest.of(paginacao.getPageNumber(), paginacao.getPageSize(), Sort.by(Sort.Direction.ASC, "nome"));

        Page<DadosListagemMedico> page = repository.findAll(paginacao)
                .map(DadosListagemMedico::new);

        return page;
    }

    @PutMapping
    @Transactional
    public  ResponseEntity<String> atualizar(@RequestBody @Valid DadosAtualizarMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body("Dados Editados com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        // Verifica se o médico com o ID especificado existe no banco de dados
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // Se o médico existir, exclua-o do banco de dados
        repository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

