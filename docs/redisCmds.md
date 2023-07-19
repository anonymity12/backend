
# enter redis

`redis-cli`

# show all keys

```md

127.0.0.1:6379> keys *
1) "like:post:269"
2) "like:post:256"
3) "like:post:261"
4) "like:post:271"
5) "like:post:255"
6) "12713118"
7) "like:post:251"
8) "cad7b0a6"
9) "like:post:259"
```

# get a kv 

for string type:

`get key`

```md

127.0.0.1:6379> get f3ed30d1
"41"
```

