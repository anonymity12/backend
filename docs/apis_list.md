family backend





## api endpoints for butterfly 

### get someone flies

http://myIp:8081/flies/yy/getAll

### post new fly: add new item

http://myIp:8081/flies/yy/newItem

### get user info

http://myIp:8081/users/yy/getInfo


## sixlog

/api/sixlog/{size}/{page}

/api/sixlog/{id}

/api/sixlog/add; post 
{
	"articleTitle":"postman ttile",
	"articleContentHtml": "postman articleContentHtml",
	"articleContentMd": "postman send articleContentMd"
}

/api/sixlog/getTotalAmount; get

like a sixlog: 
POST
http://myIp:8081/api/sixlog/likeSixLog?sixLogId=255
OK

get sixlog with like count:
GET
http://myIp:8081/api/sixlog/5/1
OK


### upload img

post /api/sixlog/covers

## login

/api/login; post
{
    "username": "tt",
    "password": "123"
}

## life indicator

/users/lifeIndicator

## ranks

获取全部用户的排名

/ranks/getRanksForShow

return:

```txt
[
    {
        "userId": 13,
        "userface": "https://picgorepo.oss-cn-beijing.aliyuncs.com//2022-11-23-13-28-38README.png",
        "cname": "玥玥",
        "growFlyCnt": 30,
        "diedFlyCnt": 0,
        "babyFlyCnt": 11
    },
    {
        "userId": 16,
        "userface": "http://myIp:8081/api/img/kw1gqejpeg",
        "cname": "天天",
        "growFlyCnt": 10,
        "diedFlyCnt": 3,
        "babyFlyCnt": 19
    },
    ...
]
```


## commit heatmap

http://myIp:8081/api/heatmap/getMyCommitHeatMap