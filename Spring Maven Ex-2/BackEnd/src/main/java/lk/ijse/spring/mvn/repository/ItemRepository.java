package lk.ijse.spring.mvn.repository;

import lk.ijse.spring.mvn.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,String> {
}
