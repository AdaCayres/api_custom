package br.com.ada.api_custom.Controller;

import br.com.ada.api_custom.Model.Person;
import br.com.ada.api_custom.Model.Search;
import br.com.ada.api_custom.Service.PersonService;
import br.com.ada.api_custom.Service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PersonController {


    @Autowired
    private PersonService personService;
    @Autowired
    private SearchService searchService;


    @GetMapping("/{id}")
    public Person procurar(@PathVariable Long id){
        Search search = new Search();
        search.setUri("/people/" + id + "/" );

        Person person = personService.getToPerson(id);
        searchService.adicionar(search);
        return person;
    }

}
