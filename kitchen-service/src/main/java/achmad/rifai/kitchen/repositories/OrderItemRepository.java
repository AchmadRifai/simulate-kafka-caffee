package achmad.rifai.kitchen.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import achmad.rifai.kitchen.models.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {

}
