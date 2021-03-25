package br.com.ada.api_custom.Repository;

import br.com.ada.api_custom.Model.Person;
import org.springframework.stereotype.Repository;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Repository
public class StarWarsRepository {


    Client client;
    WebTarget target;

    public Person getToPerson(long id){
        client = ClientBuilder.newClient();
        target = client.target("https://swapi.dev/api/people/"+id+"/");
        return target.request(MediaType.APPLICATION_JSON).get(Person.class);

    }
}
