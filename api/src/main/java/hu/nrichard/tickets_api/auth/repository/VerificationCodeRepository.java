package hu.nrichard.tickets_api.auth.repository;

import hu.nrichard.tickets_api.auth.domain.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, UUID> {
}
