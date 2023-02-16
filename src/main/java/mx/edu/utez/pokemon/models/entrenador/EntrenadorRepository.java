package mx.edu.utez.pokemon.models.entrenador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador,Integer> {
    Optional<Entrenador> findById(Integer id);

}
