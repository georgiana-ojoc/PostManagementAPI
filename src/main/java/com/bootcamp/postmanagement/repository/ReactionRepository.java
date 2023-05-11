package com.bootcamp.postmanagement.repository;

import com.bootcamp.postmanagement.model.domain.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, UUID> {
    Optional<Reaction> getByPostIdAndUserId(UUID postId, UUID userId);
}
