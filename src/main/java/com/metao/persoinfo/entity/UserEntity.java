package com.metao.persoinfo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.metao.persoinfo.util.Constants;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A user.
 */
@Entity
@Table(name = "active_user")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserEntity extends AbstractAuditingEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonIgnore
  @NotNull
  @Size(min = 60, max = 60)
  @Column(name = "password_hash", length = 60, nullable = false)
  private String password;

  @Size(max = 50)
  @Column(name = "name", length = 50)
  private String name;

  @Email
  @Size(min = 5, max = 254)
  @Column(length = 254, unique = true)
  private String email;

  @NotNull
  @Column(nullable = false)
  private boolean activated = false;

  @Size(min = 2, max = 6)
  @Column(name = "lang_key", length = 6)
  private String langKey;

  @Size(max = 256)
  @Column(name = "image_url", length = 256)
  private String imageUrl;

  @Size(max = 20)
  @Column(name = "activation_key", length = 20)
  @JsonIgnore
  private String activationKey;

  @Size(max = 20)
  @Column(name = "reset_key", length = 20)
  @JsonIgnore
  private String resetKey;

  @Column(name = "reset_date")
  private Instant resetDate = null;

  @JsonIgnore
  @ManyToMany
  @JoinTable(
    name = "user_authority",
    joinColumns = {@JoinColumn(name = "id")},
    inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
  @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
  @BatchSize(size = 20)
  private Set<Authority> authorities = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public boolean getActivated() {
    return activated;
  }

  public void setActivated(boolean activated) {
    this.activated = activated;
  }

  public String getActivationKey() {
    return activationKey;
  }

  public void setActivationKey(String activationKey) {
    this.activationKey = activationKey;
  }

  public String getResetKey() {
    return resetKey;
  }

  public void setResetKey(String resetKey) {
    this.resetKey = resetKey;
  }

  public Instant getResetDate() {
    return resetDate;
  }

  public void setResetDate(Instant resetDate) {
    this.resetDate = resetDate;
  }

  public String getLangKey() {
    return langKey;
  }

  public void setLangKey(String langKey) {
    if (langKey == null) {
      langKey = Constants.DEFAULT_LANGUAGE;
    }
    this.langKey = langKey;
  }

  public Set<Authority> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(Set<Authority> authorities) {
    this.authorities = authorities;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserEntity)) {
      return false;
    }
    return id != null && id.equals(((UserEntity) o).id);
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public String toString() {
    return "User{" +
      "  name='" + name + '\'' +
      ", email='" + email + '\'' +
      ", imageUrl='" + imageUrl + '\'' +
      ", activated='" + activated + '\'' +
      ", langKey='" + langKey + '\'' +
      ", activationKey='" + activationKey + '\'' +
      "}";
  }
}
