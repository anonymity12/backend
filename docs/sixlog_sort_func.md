# 前端期望看到sixlog组件具有排序功能

- 希望看到排序，根据likeCounts进行排序

## 后端排序里可能遇到的问题

某些 likeCounts 的数量就是 0，那么应该按照时间从新到旧 排序。

我们可以从 redis 里面获得 likeCounts 。然后从 db 里面获得每个 sixlog 的时间序列。