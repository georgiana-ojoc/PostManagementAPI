package com.bootcamp.postmanagement.service;

import com.bootcamp.postmanagement.model.request.ReactionRequest;
import com.bootcamp.postmanagement.model.response.ReactionResponse;
import com.bootcamp.postmanagement.exception.PostNotFoundException;
import com.bootcamp.postmanagement.exception.ServiceUnavailableException;

public interface ReactionService {
    ReactionResponse react(String authorization, String post, ReactionRequest request) throws PostNotFoundException,
            ServiceUnavailableException;
}
