package com.prueba.api_consumer.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Clase de configuración para el caché de la aplicación
 */
@Configuration
@EnableCaching
public class CacheConfig {

    /**
     * Método que permite establecer la caché y además establece el tiempo de la caché a 5 minutos
     * @return Retorna un objeto de tipo CacheManager el cual contiene la configuración establecida
     */
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("users");

        cacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.MINUTES));

        return cacheManager;
    }

}
