package studyspringboot.restapi.core.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studyspringboot.restapi.core.item.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
