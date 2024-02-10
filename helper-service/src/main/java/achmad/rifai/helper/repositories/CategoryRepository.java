package achmad.rifai.helper.repositories;

import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;

import achmad.rifai.helper.modals.Category;

@Repository
public interface CategoryRepository extends ReactiveElasticsearchRepository<Category, String> {

}
