package com.bootcamp.postmanagement.service.implementation;

import com.bootcamp.postmanagement.model.domain.Tag;
import com.bootcamp.postmanagement.service.TagService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.bootcamp.postmanagement.repository.TagRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class TagServiceImplementation implements TagService {
    private final TagRepository tagRepository;

    public Set<String> saveAll(UUID postId, Set<String> tags) {
        log.info("[TagService] save all tags: {} - {}", postId, tags);
        if (tags == null || tags.isEmpty()) {
            return tags;
        }
        List<Tag> savedTags = tagRepository.saveAll(tags.stream()
                .map(tag -> Tag.builder()
                        .postId(postId)
                        .name(tag)
                        .build())
                .collect(Collectors.toSet()));
        Set<String> savedTagNames = savedTags.stream().map(Tag::getName).collect(Collectors.toSet());
        log.info("[TagService] saved all tags: {}", savedTagNames);
        return savedTagNames;
    }
}
