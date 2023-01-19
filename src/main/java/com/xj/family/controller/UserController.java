package com.xj.family.controller;

import com.xj.family.bean.User;
import com.xj.family.bean.RespBean;
import com.xj.family.bean.vo.LifeIndicatorVo;
import com.xj.family.bean.dto.ValidParentDto;
import com.xj.family.service.UserService;
import com.xj.family.service.FamilyTreeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    FamilyTreeService familyTreeService;

    @GetMapping("/{username}/getInfo")
    public User getInfo(@PathVariable("username") String name) {
        return userService.getUserInfoByName(name);
    }

    @PostMapping("/validParent")
    public RespBean validParent(@RequestBody ValidParentDto item) {
        System.out.println("controller recieve valid parent dto: " + item);
        if (userService.validParent(item)) { 
            return RespBean.ok("验证通过");
        } else {
            return RespBean.error("验证不通过");
        }
    }

    @GetMapping("/lifeIndicator")
    public RespBean lifeIndicator() {
        // todo find out multi users, who make this request
        LifeIndicatorVo vo = userService.getUserLifeIndicatorVo();
        if (vo != null) {
            return RespBean.ok("got user life indicator", vo);
        } else {
            return RespBean.error("faild to get user life indicator");
        }
    }
    @GetMapping("/familyTree")
    public RespBean familyTree() {
        List<FamilyTreeEntity> entities = familyTreeService.list();
        List<FamilyTreeEntity> level1Entities = entities.stream()
                                .filter((entity) -> entity.getParentId() == 0)
                                .map((node) -> {
                                    node.setChild(getChildren(node, entities));
                                    return node;
                                })
                                .collect(Collectors.toList());
        return RespBean.ok("got family tree", level1Entities);
    }

}
