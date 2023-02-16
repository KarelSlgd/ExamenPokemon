package mx.edu.utez.pokemon.models.pokemon;

import mx.edu.utez.pokemon.models.entrenador.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface PokemonRepository extends JpaRepository<Pokemon,Integer> {

    Optional<Pokemon> findById(Integer id);
/*
    @Query(value = "select nombre as nombre_entrenador, id, ataque,pokemons.defensa, pokemons.nombre, pokemons.poder,pokemons.salud, pokemons.tipo from pokemons inner join entrenadores ON pokemons.id = entrenadores.id")
    List<Entrenador> userdata(Integer id);

 */
/*
SELECT Orders.OrderID, Customers.CustomerName
FROM Orders
INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID;
 */






    /*
        Optional<Category> findById(Long id); // optional para ver si estaba vacia
    List<Category> findAllByStatus(Boolean status);
    Optional<Category> findByName(String name);

    @Query(value = "UPDATE categories SET status = :status WHERE id = :id", nativeQuery = true)
    boolean updateStatusById(@Param("status") Boolean status, @Param("id") Long id);
     */
}
