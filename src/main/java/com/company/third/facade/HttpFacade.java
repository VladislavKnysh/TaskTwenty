package com.company.third.facade;

public interface HttpFacade {
    <T> T get(String uri, Class<T> responseClass);

    <T> T post(String uri, Object body, Class<T> responseClass);

    <T> T getAuthorized(String uri, Class<T> responseClass, String token);

    <T> T postAuthorized(String uri, Object body, Class<T> responseClass, String token);


}