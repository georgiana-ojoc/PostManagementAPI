package com.bootcamp.postmanagement.service;

import com.bootcamp.postmanagement.model.request.PostRequest;
import com.bootcamp.postmanagement.model.response.PostResponse;
import com.bootcamp.postmanagement.exception.EmptyFileException;
import com.bootcamp.postmanagement.exception.FileNotImageException;
import com.bootcamp.postmanagement.exception.InvalidImageException;
import com.bootcamp.postmanagement.exception.PostNotFoundException;
import com.bootcamp.postmanagement.exception.ServiceUnavailableException;
import com.bootcamp.postmanagement.exception.UploadFailedException;

import java.util.List;

public interface PostService {
    void checkById(String id) throws PostNotFoundException;

    PostResponse post(String authorization, PostRequest request) throws ServiceUnavailableException, EmptyFileException,
            FileNotImageException, InvalidImageException, UploadFailedException;

    List<PostResponse> getAll(String authorization) throws ServiceUnavailableException;
}
