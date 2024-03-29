package br.com.escola.ProjetoEscolaS.service;

import br.com.escola.ProjetoEscolaS.model.Aluno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AlunoService {

    public Aluno salvar(Aluno aluno) throws Exception {
        if (!validacao(aluno)) {
            return null;
        }
        return Aluno.salvar(aluno);
    }

    public boolean validacao(Aluno aluno) throws Exception {
        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new Exception("Campo nome é obrigatório, favor preencher");
        }
        return true;
    }

    public Aluno buscarPorId(Integer id) throws Exception {
        return Aluno.buscaPorId(id);
    }

    public ArrayList<Aluno> buscarTodos() {
        return Aluno.getAlunos();
    }

}
