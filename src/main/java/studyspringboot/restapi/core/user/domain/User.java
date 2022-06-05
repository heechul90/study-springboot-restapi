package studyspringboot.restapi.core.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "hc_user")
@SequenceGenerator(
        name = "user_seq_generator",
        sequenceName = "user_seq",
        initialValue = 1, allocationSize = 50
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_generator")
    @Column(name = "user_id")
    private Long id;

    private String account;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    //===생성 메서드===//
    @Builder
    public User(String account, String email, String phoneNumber, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy) {
        this.account = account;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    //===변경 메서드===//
    public void changeEmail(String email) {
        this.email = email;
    }
}
