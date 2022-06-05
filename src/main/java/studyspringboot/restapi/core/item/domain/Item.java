package studyspringboot.restapi.core.item.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import studyspringboot.restapi.core.orderDetail.domain.OrderDetail;
import studyspringboot.restapi.core.user.domain.User;

import javax.persistence.*;

@Entity
@Table(name = "hc_item")
@SequenceGenerator(
        name = "item_seq_generator",
        sequenceName = "item_seq",
        initialValue = 1, allocationSize = 50
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq_generator")
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name")
    private String name;

    private Integer price;
    private String content;

    //===생성 메서드===//
    @Builder
    public Item(String name, Integer price, String content) {
        this.name = name;
        this.price = price;
        this.content = content;
    }
}
