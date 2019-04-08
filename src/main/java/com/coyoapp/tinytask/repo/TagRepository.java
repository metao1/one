package com.coyoapp.tinytask.repo;

import com.coyoapp.tinytask.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, String> {

  Tag findTagById(String id);
}
