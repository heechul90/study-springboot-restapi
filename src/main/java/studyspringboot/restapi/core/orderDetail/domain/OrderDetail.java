package studyspringboot.restapi.core.orderDetail.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import studyspringboot.restapi.core.item.domain.Item;
import studyspringboot.restapi.core.user.domain.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "hc_order_detail")
@SequenceGenerator(
        name = "order_detail_seq_generator",
        sequenceName = "order_detail_seq",
        initialValue = 1, allocationSize = 50
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDetail {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_detail_seq_generator")
    @Column(name = "order_detail_id")
    private Long id;

    private LocalDateTime orderAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    //===생성 메서드===//
    @Builder
    public OrderDetail(LocalDateTime orderAt, User user, Item item) {
        this.orderAt = orderAt;
        this.user = user;
        this.item = item;
    }
}
