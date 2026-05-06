package cl.bibliotecaprojecto.categoria.BibliotecaProjectoCategoria.repository;

import cl.bibliotecaprojecto.categoria.BibliotecaProjectoCategoria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
