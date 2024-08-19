package br.com.leon.cursos.modules.curso.repository;

import br.com.leon.cursos.modules.curso.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CursoRepository extends JpaRepository<CursoEntity, UUID> {
}
