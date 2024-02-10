package achmad.rifai.helper.repositories;

import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;

import achmad.rifai.helper.modals.Menu;

@Repository
public interface MenuRepository extends ReactiveElasticsearchRepository<Menu, String> {

}
