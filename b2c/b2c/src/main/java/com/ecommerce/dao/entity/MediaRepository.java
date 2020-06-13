package com.ecommerce.dao.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MediaRepository extends CrudRepository<Media, String> {

  Optional<Media> findById(String id);
}