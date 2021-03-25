package br.com.ada.api_custom.Controller;

import br.com.ada.api_custom.Model.Search;
import br.com.ada.api_custom.Repository.SearchRepository;
import br.com.ada.api_custom.Service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/searches")
public class SearchController {

    @Autowired
    private SearchService searchService;
    @Autowired
    private SearchRepository searchRepository;

    @GetMapping
    public List<Search> listar(){
        return searchRepository.findAll();
    }

    @GetMapping("/id")
    public Search procurar(@PathVariable long id){
        return searchService.getToSearch(id);
    }

    @PostMapping
    public Search adicionar(@RequestBody Search search){
        return searchRepository.save(search);
    }
}
