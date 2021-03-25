package br.com.ada.api_custom.Controller;

import br.com.ada.api_custom.Model.Person;
import br.com.ada.api_custom.Model.Search;
import br.com.ada.api_custom.Repository.PersonRepository;
import br.com.ada.api_custom.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/people")
public class PersonController {


    @Autowired
    private PersonService service;
    @Autowired
    private SearchController searchController;


    @GetMapping("/{id}")
    public Person procurar(@PathVariable Long id){
        Search search = new Search();
        search.setUri("/people/" + id + "/" );
        searchController.adicionar(search);
        return service.getToPerson(id);
    }



}
