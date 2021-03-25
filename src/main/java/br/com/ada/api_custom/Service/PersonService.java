package br.com.ada.api_custom.Service;

import br.com.ada.api_custom.Model.Person;
import br.com.ada.api_custom.Repository.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Service
public class PersonService {

    @Autowired
    StarWarsRepository starWarsRepository;

    public Person getToPerson(long id){
        try{
        Person p = starWarsRepository.getToPerson(id);
        p.setId(id);
        return p;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found", e);

        }
    }
}
