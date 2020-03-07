package com.metao.persoinfo.repository;

import com.metao.persoinfo.entity.UserEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the {@link UserEntity} entity.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  String USERS_BY_LOGIN_CACHE = "usersByLogin";

  String USERS_BY_EMAIL_CACHE = "usersByEmail";

  Optional<UserEntity> findOneByActivationKey(String activationKey);

  List<UserEntity> findAllByActivatedIsFalseAndCreatedDateBefore(Instant dateTime);

  Optional<UserEntity> findOneByResetKey(String resetKey);

  Optional<UserEntity> findOneByEmailIgnoreCase(String email);

  Optional<UserEntity> findOneByEmail(String email);

  Optional<UserEntity> findById(String id);

  @EntityGraph(attributePaths = "authorities")
  Optional<UserEntity> findOneWithAuthoritiesById(String id);

  @EntityGraph(attributePaths = "authorities")
  @Cacheable(cacheNames = USERS_BY_EMAIL_CACHE)
  Optional<UserEntity> findOneWithAuthoritiesByEmail(String email);

  Page<UserEntity> findAllByEmailNot(Pageable pageable, String email);
}
