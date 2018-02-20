package com.yang.web;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.entity.Actor;
import com.yang.service.ActorService;
import com.yang.util.Result;
import com.yang.util.ResultGenerator;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Yyang
* @create 2018/01/24
*/
@RestController
@RequestMapping("/actor")
public class ActorController {
    @Resource
    private ActorService actorService;

    @PostMapping
    public Result add(Actor actor) {
        actorService.save(actor);
        return ResultGenerator.genSuccessResult("演员信息上传成功");
    }

    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable Integer id) {
        actorService.deleteById(id);
        return ResultGenerator.genSuccessResult("演员信息删除成功");
    }

    @PutMapping
    public Result update(@RequestBody Actor actor) {
        actorService.update(actor);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Actor actor = actorService.findById(id);
        return ResultGenerator.genSuccessResult(actor);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        System.out.println("获取所有演员信息 "+"page:" + page + "," + "size:" + size);
        Condition condition = new Condition(Actor.class);
        condition.setOrderByClause("actorId desc");

        PageHelper.startPage(page, size);
        List<Actor> list = actorService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);

        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
