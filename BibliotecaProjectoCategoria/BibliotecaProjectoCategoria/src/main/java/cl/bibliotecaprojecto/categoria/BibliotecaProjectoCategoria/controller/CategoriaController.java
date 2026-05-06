package cl.bibliotecaprojecto.categoria.BibliotecaProjectoCategoria.controller;

import cl.bibliotecaprojecto.categoria.BibliotecaProjectoCategoria.dto.CategoriaResponseDTO;
import cl.bibliotecaprojecto.categoria.BibliotecaProjectoCategoria.model.Categoria;
import cl.bibliotecaprojecto.categoria.BibliotecaProjectoCategoria.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categorias")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> obtenerTodos() {
        return ResponseEntity.ok(categoriaService.obtenerTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> obtenerPorId(@PathVariable Long id){
        return categoriaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Categoria> crear(@Valid @RequestBody Categoria categoria) {
        Categoria nuevaC = categoriaService.guardar(categoria);
        return ResponseEntity.status(201).body(nuevaC);
    }

    @PutMapping("{id}")
    public ResponseEntity<Categoria> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Categoria datos){
        return categoriaService.obtenerPorId(id)
                .map(existente -> {
                    datos.setId(id);
                    return ResponseEntity.ok(categoriaService.guardar(datos));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        if (categoriaService.obtenerPorId(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        categoriaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
