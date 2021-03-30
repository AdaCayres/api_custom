package br.com.ada.api_custom.Service;

import br.com.ada.api_custom.Model.Search;
import br.com.ada.api_custom.Repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    public List<Search> listar() {
        System.out.println("["+ System.nanoTime() +"]" + "Exhibiting all searches in our database");
        return searchRepository.findAll();
    }


    public Search getToSearch(long id){
        System.out.println("["+ System.nanoTime() +"]" + "Looking for search in our database");
        Optional<Search> search = searchRepository.findById(id);
        if(!search.isPresent())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");
        System.out.println("["+ System.nanoTime() +"]" + "Found search in our database");
        return search.get();
    }


    public Search adicionar(@RequestBody Search search) {
        System.out.println("["+ System.nanoTime() +"]" + "Saving search in our database");
        return searchRepository.save(search);
    }

}
