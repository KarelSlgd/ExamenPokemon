package mx.edu.utez.pokemon.models.entrenador;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.models.pokemon.Pokemon;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "entrenadores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Entrenador {
    /*
        ID del entrenador (entero, clave primaria)
        Nombre del entrenador (texto)
        Equipo de Pokemon (texto)

     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 50)
    private String nombre;
    @Column(nullable = false,length = 50)
    private String equipo;

    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;
}
