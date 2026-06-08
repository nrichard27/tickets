package hu.nrichard.tickets_api.auth.domain;

import hu.nrichard.tickets_api.user.domain.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "verification_codes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class VerificationCode {

    @Id
    @Generated
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "user_id", insertable = false, updatable = false)
    private UUID userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "channel", nullable = false, length = 50)
    private VerificationChannel channel;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 50)
    private VerificationType type;

    @Column(name = "code", nullable = false, length = 10)
    private String code;

    @Column(name = "consumed_at")
    private Instant consumedAt;

    @Column(name = "expires_at", nullable = false, updatable = false)
    private Instant expiresAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

}
