package studyspringboot.restapi.core.orderDetail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studyspringboot.restapi.core.orderDetail.domain.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
