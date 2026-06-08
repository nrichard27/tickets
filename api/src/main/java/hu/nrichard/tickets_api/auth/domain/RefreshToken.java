package hu.nrichard.tickets_api.auth.domain;

import hu.nrichard.tickets_api.user.domain.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.net.InetAddress;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "refresh_tokens")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RefreshToken {

    @Id
    @Column(name = "jti", nullable = false, updatable = false)
    private UUID jti;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "root_jti")
    private RefreshToken rootJti;

    @Column(name = "root_jti", insertable = false, updatable = false)
    private UUID rootJtiId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "replaced_by")
    private RefreshToken replacedBy;

    @Column(name = "replaced_by", insertable = false, updatable = false)
    private UUID replacedById;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "user_id", insertable = false, updatable = false)
    private UUID userId;

    @CreationTimestamp
    @Column(name = "issued_at", nullable = false, updatable = false)
    private Instant issuedAt;

    @Column(name = "expires_at", nullable = false, updatable = false)
    private Instant expiresAt;

    @Column(name = "rotated_at")
    private Instant rotatedAt;

    @Column(name = "revoked_at")
    private Instant revokedAt;

    @Column(name = "ip")
    private InetAddress ip;

    @Column(name = "user_agent", columnDefinition = "TEXT")
    private String userAgent;

}
