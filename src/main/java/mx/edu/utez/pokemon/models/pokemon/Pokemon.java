package mx.edu.utez.pokemon.models.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.models.entrenador.Entrenador;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pokemons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pokemon {

    /*
    ID del Pokemon (entero, clave primaria)
    Nombre del Pokemon (texto)
    Tipo de Pokemon (texto)
    Nivel de poder (entero)
    Puntos de salud (entero)
    Ataque (entero)
    Defensa (entero)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 50)
    private String nombre;
    @Column(nullable = false,length = 50)
    private String tipo;
    @Column(nullable = false,length = 50)
    private Integer poder;
    @Column(nullable = false,length = 50)
    private Integer salud;
    @Column(nullable = false,length = 50)
    private Integer ataque;
    @Column(nullable = false,length = 50)
    private Integer defensa;


    @OneToMany(mappedBy = "pokemon")
    @JsonIgnore
    private List<Entrenador> entrenadores;

}
