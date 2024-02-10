package achmad.rifai.kitchen.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import achmad.rifai.kitchen.models.Category;
import achmad.rifai.kitchen.models.Menu;

public interface MenuRepository extends JpaRepository<Menu, UUID> {

	Optional<Menu> findByNameAndCategory(String name, Category category);
}
