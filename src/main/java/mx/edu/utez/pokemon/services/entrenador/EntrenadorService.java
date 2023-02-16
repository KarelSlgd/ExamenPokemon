package mx.edu.utez.pokemon.services.entrenador;

import mx.edu.utez.pokemon.models.entrenador.Entrenador;
import mx.edu.utez.pokemon.models.entrenador.EntrenadorRepository;
import mx.edu.utez.pokemon.models.pokemon.Pokemon;
import mx.edu.utez.pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Entrenador>> getAll(){
        return new Response<List<Entrenador>>(
                this.repository.findAll(), false, 200, "Esta bien"
        );
    }

    @Transactional(readOnly= true)
    public Response<Entrenador> getOne(Integer id) {
        if(this.repository.existsById(id)){
            return new Response<>(
                    this.repository.findById(id).get(), false,200, "ok"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el entrenador"
        );

    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenador> insert(Entrenador entrenador){
        return new Response<>(
                this.repository.saveAndFlush(entrenador), false,200,"Entrenador registrado"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenador> update(Entrenador entrenador){
        if(this.repository.existsById(entrenador.getId())){
            return new Response<>(
                    this.repository.saveAndFlush(entrenador), false,200,"Entrenador actualizado"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el entrenador"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenador> delete(Integer id){
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
            return new Response<>(
                    null, false,200,"Entrenador eliminado"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el entrenador"
        );
    }


}
