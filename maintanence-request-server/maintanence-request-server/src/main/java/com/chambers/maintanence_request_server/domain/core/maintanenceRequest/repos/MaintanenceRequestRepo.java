package com.chambers.maintanence_request_server.domain.core.maintanenceRequest.repos;

import com.chambers.maintanence_request_server.domain.core.maintanenceRequest.models.MaintanenceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MaintanenceRequestRepo extends JpaRepository<MaintanenceRequest, Long> {
    Optional<MaintanenceRequest> findByEmail(String email);

}
