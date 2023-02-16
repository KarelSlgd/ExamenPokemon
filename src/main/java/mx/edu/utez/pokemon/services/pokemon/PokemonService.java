package mx.edu.utez.pokemon.services.pokemon;

import jdk.jfr.Category;
import mx.edu.utez.pokemon.models.pokemon.Pokemon;
import mx.edu.utez.pokemon.models.pokemon.PokemonRepository;
import mx.edu.utez.pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PokemonService {

    @Autowired
    private PokemonRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Pokemon>> getAll(){
        return new Response<List<Pokemon>>(
                this.repository.findAll(), false, 200, "Esta bien"
        );
    }

    @Transactional(readOnly= true)
    public Response<Pokemon> getOne(Integer id) {
        if(this.repository.existsById(id)){
            return new Response<>(
                    this.repository.findById(id).get(), false,200, "ok"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el pokemon"
        );

    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> insert(Pokemon pokemon){
        return new Response<>(
                this.repository.saveAndFlush(pokemon), false,200,"Pokemon registrado"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> update(Pokemon pokemon){
        if(this.repository.existsById(pokemon.getId())){
            return new Response<>(
                    this.repository.saveAndFlush(pokemon), false,200,"Pokemon actualizado"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el pokemon"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> delete(Integer id){
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
            return new Response<>(
                    null, false,200,"Pokemon eliminado"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el pokemon"
        );
    }


}
