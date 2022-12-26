family backend

## api endpoints for butterfly 

### get someone flies

http://101.43.166.211:8081/flies/yy/getAll

### post new fly: add new item

http://101.43.166.211:8081/flies/yy/newItem

### get user info

http://101.43.166.211:8081/users/yy/getInfo


## sixlog

/api/sixlog/{size}/{page}

/api/sixlog/{id}

/api/sixlog/add; post 
{
	"articleTitle":"postman ttile",
	"articleContentHtml": "postman articleContentHtml",
	"articleContentMd": "postman send articleContentMd"
}

## login

/api/login; post
{
    "username": "tt",
    "password": "123"
}