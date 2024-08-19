package br.com.leon.cursos.exception;

public class CursoNotFoundException extends RuntimeException {
    public CursoNotFoundException() {
        super("Curso not found");
    }
}
