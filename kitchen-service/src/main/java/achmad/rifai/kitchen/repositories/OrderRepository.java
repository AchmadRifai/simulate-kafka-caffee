package achmad.rifai.kitchen.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import achmad.rifai.kitchen.models.Order;

public interface OrderRepository extends JpaRepository<Order, UUID> {

}
