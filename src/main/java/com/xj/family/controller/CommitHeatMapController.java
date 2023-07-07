
// basic framework of Commit Heat Map Controller
public class CommitHeatMapController {
  @Autowired
  CommitHeatMapService commitHeatMapService;
  @GetMapping("/getMyCommitHeatMap")
  public RespBean<List<CommitRedisView>> getMyCommitHeatMap() {
    Integer userId = ThreadLocalUser.get();
    List<CommitRedisView> commits = commitHeatMapService.getMyCommitHeatMap(userId);
    return RespBean.ok("got your this month commits heatmap", commits);
  }
}

// basic of service
public class CommitHeatMapService {
  @Autowired
  CommitHeatMapMapper commitHeatMapMapper;
  public List<CommitRedisView> getMyCommitHeatMap(Integer userId) {
    List<CommitDBView> dbViews = commitHeatMapMapper.calcCommitForOnePerson(userId);
    List<CommitRedisView> redisViews = new ArrayList<CommitRedisView>();
    for (CommitDBView view: dbViews){
      CommitRedisView redisView = new CommitRedisView();
      redisView.setSimplifiedDateString(new Date(view.getDateString()).format("YYYY-MM-DD"));
      redisViews.add(redisView);
    }
    return redisViews;
  }
}
// basic of mapper
@Mapper
public interface CommitHeatMapMapper {
  public List<CommitDBView> calcCommitForOnePerson(Integer userId);
}
// mapper xml: CommitHeatMapMapper.xml
<mapper>
<select>
  select count(*) from task where ownerId=#{userId} group by date;
</select>
</mapper>
  
