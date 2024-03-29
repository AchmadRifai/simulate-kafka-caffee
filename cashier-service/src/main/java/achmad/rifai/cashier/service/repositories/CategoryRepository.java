package achmad.rifai.cashier.service.repositories;

import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import org.springframework.stereotype.Repository;

import achmad.rifai.cashier.service.modals.Category;

@Repository
public interface CategoryRepository extends ReactiveElasticsearchRepository<Category, String> {

}
