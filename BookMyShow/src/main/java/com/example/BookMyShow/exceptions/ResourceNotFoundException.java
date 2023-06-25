package com.example.BookMyShow.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    String resourceName;
    String fieldName;
    Integer fieldValue;
    public ResourceNotFoundException(String resourceName, String fieldName, Integer value) {
        super(String.format("%s not found with %s: %s", resourceName, fieldName, value));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = value;
    }
}
