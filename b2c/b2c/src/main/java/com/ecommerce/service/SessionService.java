package com.ecommerce.service;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class SessionService {

    @Autowired
    ObjectFactory<HttpSession> httpSessionFactory;

    public HttpSession getCurrentSession() {
        return httpSessionFactory.getObject();
    }

}
