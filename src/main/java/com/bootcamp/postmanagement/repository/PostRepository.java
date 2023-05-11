package com.bootcamp.postmanagement.repository;

import com.bootcamp.postmanagement.model.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> getAllByUserId(UUID userId);
}
