package mx.edu.utez.pokemon.controller.entrenador.dto;

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
public class EntrenadorDto {

        /*
        ID del entrenador (entero, clave primaria)
        Nombre del entrenador (texto)
        Equipo de Pokemon (texto)

     */
    private  Integer id;
    private String nombre;
    private  String equipo;
    private  Pokemon pokemon;
    public Entrenador getEntrenador(){
        return new Entrenador(getId(),getNombre(),getEquipo(),pokemon);
    }

}
