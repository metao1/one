package com.metao.persoinfo.config;

import com.metao.persoinfo.entity.Authority;
import com.metao.persoinfo.entity.Tag;
import com.metao.persoinfo.entity.Task;
import com.metao.persoinfo.entity.UserEntity;
import com.metao.persoinfo.properties.PersoInfoProperties;
import com.metao.persoinfo.repository.UserRepository;
import org.ehcache.config.builders.*;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.cache.Cache;
import javax.cache.CacheManager;
import java.time.Duration;
import org.hibernate.cache.jcache.ConfigSettings;

@Configuration
@EnableCaching
public class CacheConfiguration {

  private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

  public CacheConfiguration(PersoInfoProperties persoInfoProperties) {
    PersoInfoProperties.Cache.Ehcache ehcache =
      persoInfoProperties.getCache().getEhcache();

    jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
      CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
        ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
        .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
        .build());
  }

  @Bean
  public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(javax.cache.CacheManager cacheManager) {
    return hibernateProperties -> hibernateProperties.put(ConfigSettings.CACHE_MANAGER, cacheManager);
  }

  @Bean
  public JCacheManagerCustomizer cacheManagerCustomizer() {
    return cm -> {
      createCache(cm, UserRepository.USERS_BY_LOGIN_CACHE);
      createCache(cm, UserRepository.USERS_BY_EMAIL_CACHE);
      createCache(cm, UserEntity.class.getName());
      createCache(cm, Authority.class.getName());
      createCache(cm, UserEntity.class.getName() + ".authorities");
      createCache(cm, Tag.class.getName() + ".operations");
      createCache(cm, Task.class.getName() + ".operations");
    };
  }

  private void createCache(CacheManager cm, String cacheName) {
    Cache<Object, Object> cache = cm.getCache(cacheName);
    if (cache != null) {
      cm.destroyCache(cacheName);
    }
    cm.createCache(cacheName, jcacheConfiguration);
  }
}
