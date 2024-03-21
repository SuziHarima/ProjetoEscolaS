package br.com.escola.ProjetoEscolaS.service;

import br.com.escola.ProjetoEscolaS.model.Aluno;
import br.com.escola.ProjetoEscolaS.model.Curso;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class CursoService {

    private final AlunoService alunoService;

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

    public ArrayList<Curso> buscarTodos() {
        return Curso.getCursos();
    }

    public Curso buscarPorId(Integer id) throws Exception {
        return  Curso.buscarPorId(id);
    }

    public Curso matricular(Integer id, Integer idAluno) throws Exception{
        Curso curso = buscarPorId(id);
        Aluno aluno = alunoService.buscarPorId(idAluno);
        curso.matricular(curso, aluno);
        return curso;
    }

}
