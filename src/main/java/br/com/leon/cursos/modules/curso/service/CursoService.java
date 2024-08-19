package br.com.leon.cursos.modules.curso.service;

import br.com.leon.cursos.exception.CursoNotFoundException;
import br.com.leon.cursos.modules.curso.CursoEntity;
import br.com.leon.cursos.modules.curso.enums.Status;
import br.com.leon.cursos.modules.curso.repository.CursoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CursoService {

    private CursoRepository cursoRepository;

    public CursoEntity saveCurso(CursoEntity curso) {
        UUID id = curso.getId();

        if(id != null){
            CursoEntity cursoFounded = this.findCurso(id);
            curso.setCreatedAt(cursoFounded.getCreatedAt());
        }
        return cursoRepository.save(curso);
    }

    public List<CursoEntity> listCursos() {
        return cursoRepository.findAll();
    }

    public void deleteCurso(UUID id) {
        this.findCurso(id);

        cursoRepository.deleteById(id);
    }

    public Status activeCurso(UUID id) {
        CursoEntity curso = this.findCurso(id);
        return curso.getActive();
    }

    private CursoEntity findCurso(UUID id){
        return cursoRepository.findById(id)
                .orElseThrow(CursoNotFoundException::new);
    }
}
