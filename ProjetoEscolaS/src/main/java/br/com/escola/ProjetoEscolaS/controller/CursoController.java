package br.com.escola.ProjetoEscolaS.controller;

import br.com.escola.ProjetoEscolaS.model.Curso;
import br.com.escola.ProjetoEscolaS.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RequiredArgsConstructor
@RestController
@RequestMapping("curso")
public class CursoController {

    public final CursoService cursoService;

    @PostMapping
    public Curso post(@RequestBody Curso curso) throws Exception {
        return cursoService.salvar(curso);
    }

    @GetMapping
    public ArrayList<Curso> get() {
        return cursoService.buscarTodos();
    }

}
