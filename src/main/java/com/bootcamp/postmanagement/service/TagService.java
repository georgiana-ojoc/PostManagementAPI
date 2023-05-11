package com.bootcamp.postmanagement.service;

import java.util.Set;
import java.util.UUID;

public interface TagService {
    Set<String> saveAll(UUID postId, Set<String> tags);
}
