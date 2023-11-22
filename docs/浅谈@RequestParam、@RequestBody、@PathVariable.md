https://zhuanlan.zhihu.com/p/624114484

# @RequestParam

```
@RequestParam注解一般与get请求一起使用。但是也可配合post请求使用，见SixLogController：：likeSixLog
一个请求（一个方法中）可以有多个@RequestParam。
@RequestParam 用来接收普通参数
```



# @RequestBody（常用）

```
@RequestBody注解一般与post方法使用。
一个请求中只能存在一个@RequestBody注解。
@RequestBody 用于接收前端传递给后端的json字符串中的数据。（处理json格式的数据）
```


# @PathVariable（restful常用）

见 `CardSquareController.java::@GetMapping("/send-buy-request/{cardId}")`