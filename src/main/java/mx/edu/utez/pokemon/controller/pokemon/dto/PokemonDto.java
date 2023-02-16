package mx.edu.utez.pokemon.controller.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.models.entrenador.Entrenador;
import mx.edu.utez.pokemon.models.pokemon.Pokemon;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PokemonDto {
    private Integer id;
    private String nombre;
    private String tipo;
    private Integer poder;
    private Integer salud;
    private Integer ataque;
    private Integer defensa;

    public Pokemon getPokemon() {
        return new Pokemon(getId(), getNombre(), getTipo(), getPoder(), getSalud(), getAtaque(), getDefensa(), null);
    }
}