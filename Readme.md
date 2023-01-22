# tech I used

- java
- mysql
- redis

# detail works

## register related

- [x] code support for register
- [x] register  by chinese name
    - [x] use pinyin4j lib in idea
- [ ] login by chinese name or english name 

## run redis for user identification

- [x] centos run redis
- [x] pull into tencenttt
- [x] run in tecenttt
- [x] test read and write info for redis
    - [x] redis cli client


## family tree works

- [x] clean compile error

## add sixlog with user identity
    
- [x] redis support from gulimall code copy
- [x] sixlog add owner field(db, and entity) 

```txt
class: CartInterceptor implements HandlerInterceptor
field: CartInterceptor.(static).ThreadLocal<UserInfo> threadLocal 

see notibility

```

### bug: dont know how to use redisTemplate

https://www.notion.so/bug-redis-216a64a3bb084321bc69a6a7f12eb944


# end