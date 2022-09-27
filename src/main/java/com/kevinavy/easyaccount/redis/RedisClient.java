package com.kevinavy.easyaccount.redis;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class RedisClient {
    private static final Logger logger = LogManager.getLogger(RedisClient.class);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public boolean add(String key, Object value) {
        try {
            if (Boolean.FALSE.equals(redisTemplate.hasKey(key))) {
                redisTemplate.opsForValue().set(key, value);
                return true;
            }
            else {
                logger.error("record {key: {}} already exist", key);
            }
        } catch (Exception e) {
            logger.error("add {key: {}, value: {}} to redis failed", key, value);
            return false;
        }
        return false;
    }

    public boolean add(String key, Object value, Long expireTime) {
        try {
            if (Boolean.FALSE.equals(redisTemplate.hasKey(key))) {
                redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
                return true;
            }
        } catch (Exception e) {
            logger.error("add {key: {}, value: {}} to redis failed", key, value);
            return false;
        }
        return false;
    }

    public boolean delete(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            logger.error("delete {key: {}} from redis failed", key);
            return false;
        }
    }

    public boolean update(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            logger.error("update {key: {}, value: {}} to redis failed", key, value);
            return false;
        }
    }

    public boolean update(String key, Object value, Long expireTime) {
        try {
            redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            logger.error("update {key: {}, value: {}} to redis failed", key, value);
            return false;
        }
    }

    public Optional<Object> get(String key) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(key));
    }

    public boolean isExist(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    public boolean setExpireTime(String key, Long expireTime) {
        try {
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            logger.error("set expire time failed");
            return false;
        }
    }

    public Long getExpireTime(String key) {
        try {
            return redisTemplate.getExpire(key, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error("get expire time failed");
            return -1L;
        }
    }


}
