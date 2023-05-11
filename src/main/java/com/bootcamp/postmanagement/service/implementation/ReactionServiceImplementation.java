package com.bootcamp.postmanagement.service.implementation;

import com.bootcamp.postmanagement.model.domain.Reaction;
import com.bootcamp.postmanagement.model.request.ReactionRequest;
import com.bootcamp.postmanagement.model.response.ReactionResponse;
import com.bootcamp.postmanagement.model.response.UserResponse;
import com.bootcamp.postmanagement.service.PostService;
import com.bootcamp.postmanagement.service.ReactionService;
import com.bootcamp.postmanagement.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.bootcamp.postmanagement.exception.PostNotFoundException;
import com.bootcamp.postmanagement.exception.ServiceUnavailableException;
import com.bootcamp.postmanagement.repository.ReactionRepository;

import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ReactionServiceImplementation implements ReactionService {
    private final PostService postService;
    private final UserService userService;
    private final ReactionRepository reactionRepository;

    @Override
    public ReactionResponse react(String authorization, String post, ReactionRequest request)
            throws PostNotFoundException, ServiceUnavailableException {
        UserResponse userResponse = userService.getInformation(authorization);
        log.info("[ReactionService] {} {} reacts: {} - {}", userResponse.getFirstName(), userResponse.getLastName(),
                post, request);
        postService.checkById(post);
        Reaction reaction = reactionRepository.getByPostIdAndUserId(UUID.fromString(post), userResponse.getId()).
                orElse(Reaction.builder()
                        .postId(UUID.fromString(post))
                        .userId(userResponse.getId())
                        .firstName(userResponse.getFirstName())
                        .lastName(userResponse.getLastName())
                        .build());
        reaction.setReactionType(request.getReactionType());
        reaction = reactionRepository.save(reaction);
        ReactionResponse reactionResponse = ReactionResponse.builder()
                .user(UserResponse.builder()
                        .id(reaction.getUserId())
                        .firstName(reaction.getFirstName())
                        .lastName(reaction.getLastName())
                        .build())
                .reactionType(reaction.getReactionType())
                .build();
        log.info("[ReactionService] {} {} reacted: {} - {}", userResponse.getFirstName(), userResponse.getLastName(),
                post, reactionResponse);
        return reactionResponse;
    }
}
