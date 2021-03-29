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
        return searchRepository.findAll();
    }


    public Search getToSearch(long id){
        Optional<Search> search = searchRepository.findById(id);

        if(!search.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");

        return search.get();
    }


    public Search adicionar(@RequestBody Search search) {
        return searchRepository.save(search);
    }

}
