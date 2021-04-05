package br.com.ada.api_custom.Service;

import br.com.ada.api_custom.Model.Search;
import br.com.ada.api_custom.Repository.SearchRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SearchService {


    @Autowired
    private SearchRepository searchRepository;

    public List<Search> listar() {
        log.info("["+ System.nanoTime() +"]" + "Exhibiting all searches in our database");
        return searchRepository.findAll();
    }


    public Search getToSearch(long id){
        log.info("["+ System.nanoTime() +"]" + "Looking for search in our database");
        Optional<Search> search = searchRepository.findById(id);
        if(!search.isPresent())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");
        log.info("["+ System.nanoTime() +"]" + "Found search in our database");
        return search.get();
    }


    public Search adicionar(@RequestBody Search search) {
        log.info("["+ System.nanoTime() +"]" + "Saving search in our database");
        return searchRepository.save(search);
    }

}
