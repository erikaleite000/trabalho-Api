package carregabanco.controller;

import java.util.List;

import carregabanco.model.AlunoModel;
import carregabanco.repository.AlunoDao;

public class AlunoController {
	
	public void inserir(AlunoModel aluno) {
		AlunoDao alunoDao = AlunoDao.getInstance();
		alunoDao.persist(aluno);
	}
	
	public List<AlunoModel> buscar() {
		AlunoDao alunoDao = AlunoDao.getInstance();
		return alunoDao.findAll();
	}
	
	public void removerPorID(Long id) {
		AlunoDao alunoDao = AlunoDao.getInstance();
		alunoDao.removeById(id);
	}
	
	public void editar(AlunoModel aluno) {
		AlunoDao alunoDao = AlunoDao.getInstance();
		alunoDao.merge(aluno);;
	}
        @GetMapping("/buscar-por-periodo")
      public List<Aluno> buscarPorPeriodo(@RequestParam String periodo) {
      return alunoRepository.findByPeriodoEntrada(periodo);

      }
		private void validarAluno(AlunoModel aluno) {
        if (aluno.getCampus() == null || aluno.getCampus().isBlank()) {
            throw new IllegalArgumentException("O campo 'campus' é obrigatório.");
        }
        if (aluno.getCurso() == null || aluno.getCurso().isBlank()) {
            throw new IllegalArgumentException("O campo 'curso' é obrigatório.");
        }
        if (aluno.getNome_estudante() == null || aluno.getNome_estudante().isBlank()) {
            throw new IllegalArgumentException("O campo 'nome do estudante' é obrigatório.");
        }
        if (aluno.getIdade() <= 0) {
            throw new IllegalArgumentException("O campo 'idade' deve ser maior que zero.");
        }
        if (aluno.getEmail_institucional() == null || aluno.getEmail_institucional().isBlank()) {
            throw new IllegalArgumentException("O campo 'email institucional' é obrigatório.");
        }
        if (!aluno.getEmail_institucional().contains("@")) {
            throw new IllegalArgumentException("O campo 'email institucional' deve ser um e-mail válido.");
        }
        if (aluno.getPeriodo_entrada() == null || aluno.getPeriodo_entrada().isBlank()) {
            throw new IllegalArgumentException("O campo 'período de entrada' é obrigatório.");
        }
    }
}


