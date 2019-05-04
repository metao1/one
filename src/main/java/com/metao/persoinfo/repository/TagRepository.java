package com.metao.persoinfo.repository;

import com.metao.persoinfo.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, String> {

  Optional<Tag> findByTitle(String title);

  Optional<Tag> findById(String id);
}
