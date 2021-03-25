package br.com.ada.api_custom.Repository;

import br.com.ada.api_custom.Model.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<Search,Long>{
}
