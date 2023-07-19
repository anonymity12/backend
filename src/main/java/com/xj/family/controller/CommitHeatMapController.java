package com.xj.family.controller;
import com.xj.family.bean.CommitRedisView;
import com.xj.family.bean.RespBean;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.service.CommitHeatMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// basic framework of Commit Heat Map Controller
@CrossOrigin
@RestController
@RequestMapping("/testapi/heatmap")
public class CommitHeatMapController {
  @Autowired
  CommitHeatMapService commitHeatMapService;
  @GetMapping("/getMyCommitHeatMap")
  public RespBean getMyCommitHeatMap() {
    Integer userId = LoginInterceptor.threadLocalUserId.get();
    List<CommitRedisView> commits = commitHeatMapService.getMyCommitHeatMap(userId);
    return RespBean.ok("got all your commits heatmap: ", commits);
  }
}
