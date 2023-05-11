package com.bootcamp.postmanagement.service;

import com.bootcamp.postmanagement.exception.UploadFailedException;

import java.io.InputStream;

public interface AmazonService {
    String upload(String path, String name, InputStream inputStream, String contentType, long contentLength,
                  int minutes) throws UploadFailedException;
}
