package br.com.leon.cursos.modules.curso.controller;


import br.com.leon.cursos.modules.curso.CursoEntity;
import br.com.leon.cursos.modules.curso.service.CursoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/cursos")
@AllArgsConstructor
public class CursoController {

    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Object> createCurso(@Valid @RequestBody CursoEntity curso){
        try {
            CursoEntity result = this.cursoService.saveCurso(curso);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> listCursos(){
        try {
            return ResponseEntity.ok(this.cursoService.listCursos());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCurso(@PathVariable UUID id, @Valid @RequestBody CursoEntity curso){
        try {
            if(Objects.isNull(id)){
                return ResponseEntity.badRequest().body("The id is required");
            }
            curso.setId(id);
            CursoEntity result = this.cursoService.saveCurso(curso);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCurso(@PathVariable UUID id){
        try {
            this.cursoService.deleteCurso(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> activeCurso(@PathVariable UUID id){
        try {
            return ResponseEntity.ok(this.cursoService.activeCurso(id).getDescription());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
