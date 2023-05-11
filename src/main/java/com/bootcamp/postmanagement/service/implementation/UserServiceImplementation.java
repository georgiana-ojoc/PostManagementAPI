package com.bootcamp.postmanagement.service.implementation;

import com.bootcamp.postmanagement.model.response.UserResponse;
import com.bootcamp.postmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import com.bootcamp.postmanagement.exception.ServiceUnavailableException;

@Service
public class UserServiceImplementation implements UserService {
    @Value(value = "${userManagement.url}")
    private String userManagementUrl;

    @Override
    public UserResponse getInformation(String authorization) throws ServiceUnavailableException {
        try {
            return WebClient.create(userManagementUrl)
                    .get()
                    .header(HttpHeaders.AUTHORIZATION, authorization)
                    .retrieve()
                    .bodyToMono(UserResponse.class)
                    .block();
        } catch (WebClientResponseException exception) {
            throw new ServiceUnavailableException("The UserManagement microservice is not available.");
        }
    }
}
