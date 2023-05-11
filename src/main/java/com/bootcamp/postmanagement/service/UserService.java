package com.bootcamp.postmanagement.service;

import com.bootcamp.postmanagement.model.response.UserResponse;
import com.bootcamp.postmanagement.exception.ServiceUnavailableException;

public interface UserService {
    UserResponse getInformation(String authorization) throws ServiceUnavailableException;
}
