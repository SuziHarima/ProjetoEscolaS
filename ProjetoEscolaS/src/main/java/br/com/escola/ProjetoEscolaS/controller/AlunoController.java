package br.com.escola.ProjetoEscolaS.controller;

import br.com.escola.ProjetoEscolaS.model.Aluno;
import br.com.escola.ProjetoEscolaS.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("aluno")
public class AlunoController {

    public final AlunoService alunoService;

    @PostMapping
    public Aluno post(@RequestBody Aluno aluno) throws Exception {
        return alunoService.salvar(aluno);
    }

    @GetMapping
    public ArrayList<Aluno> get() {
        return alunoService.buscarTodos();
    }
}
