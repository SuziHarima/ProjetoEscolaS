package br.com.escola.ProjetoEscolaS.service;

import br.com.escola.ProjetoEscolaS.model.Curso;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CursoService {

    public Curso salvar(Curso curso) throws Exception {
        if (!validacao(curso)) {
            return null;
        }
        return Curso.salvar(curso);

    }

    public boolean validacao(Curso curso) throws Exception {
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new Exception("Campo nome é obrigatório, favor preencher");
        }
        if (curso.getCargaHoraria() == null) {
            throw new Exception("Campo carga horária é obrigatório, favor preencher");
        }
        return true;
    }

    public ArrayList<Curso> buscarTodos() throws Exception {
        return Curso.getCursos();
    }

}
