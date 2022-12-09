
```java
public class DiscussPost {

    @Id
    private int id;

    private int userId;

    private String title;

    private String content;

    private int type;

    private int status;

    private Date createTime;

    private int commentCount;

    private double score;
```

# copy to mine

## controller

```java
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;


    @PostMapping("/{username}/add")
    @ResponseBody
    public RespBean addPost(String title, String content, @PathVariable("username") name) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setUserId(user.getId());

        if (postService.addPost(post) == 1) {
            return RespBean.ok("发布新帖子成功");
        } else {
            return RespBean.error("add")
        }

    }
    // todo: use page
    @GetMapping("/allPost")
    @ResponseBody
    public List<Post> getAllPosts() {
        List<Post> list = postService.findAllPosts();
        return list;
    }
    // top one post

    // delete on post 

    // todo: comment related logic goes into each method 
}
```

## service

```java
@Service
public class PostService {
    @Autowired
    PostMapper postMapper;

    public List<Post> getAllPosts () {
        return postMapper.getAll();
    }

    public int add(Post post) {
        int result = postMapper.insert(post);
        return result;
    }
}
```

## mapper 

```java
@Mapper
public interface PostMapper {
    List<Post> getAll();
    int add(Post post);
}

```xml
<mapper namespace="com.xj.family.mapper.PostMapper"
    <select id="getAllItems" resultType="com.xj.family.bean.Post">
        select * from post;
    </select>
    <insert id="insert" parameterType="com.xj.family.bean.Post">
        insert into post (content, owner)
        values (#{content, jdbcType=VARCHAR}, #{userId})
    </insert>
</mapper>
```