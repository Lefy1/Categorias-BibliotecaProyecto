package cl.bibliotecaprojecto.categoria.BibliotecaProjectoCategoria.service;

import cl.bibliotecaprojecto.categoria.BibliotecaProjectoCategoria.model.Categoria;
import cl.bibliotecaprojecto.categoria.BibliotecaProjectoCategoria.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public List<Categoria> obtenerTodos(){return categoriaRepository.findAll();}

    public Optional<Categoria> obtenerPorId(Long id){return categoriaRepository.findById(id);}

    public Categoria guardar(Categoria categoria){return categoriaRepository.save(categoria);}

    public void eliminar(Long id){categoriaRepository.deleteById(id);}
}
