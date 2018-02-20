package com.yang.web;

import com.yang.entity.Remark;
import com.yang.service.RemarkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.util.DateReplaceUtil;
import com.yang.util.Result;
import com.yang.util.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Yyang
* @create 2018/01/05
*/
@RestController
@RequestMapping("/remark")
public class RemarkController {
    @Resource
    private RemarkService remarkService;

    @PostMapping
    public Result add(String content, Integer movieId, Integer userId) {
        System.out.println("评论"+content+" "+
                " 电影："+movieId.intValue()+
                " 用户："+userId.intValue());
        remarkService.addRemark(content, movieId.intValue(), userId.intValue());
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 查询电影的评论
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result movieReamrk(@PathVariable Integer id) {
        List<Remark> remarks = remarkService.remarkByMovieId(id);
        DateReplaceUtil.remarkDateUtil(remarks);
        return ResultGenerator.genSuccessResult(remarks);
    }

    @GetMapping("/my/{id}")
    public Result userReamrk(@PathVariable Integer id) {
        List<Remark> remarks = remarkService.remarkByUserId(id);
        DateReplaceUtil.remarkDateUtil(remarks);
        return ResultGenerator.genSuccessResult(remarks);
    }

    @GetMapping("/all")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Remark> list = remarkService.remarkAll();
        DateReplaceUtil.remarkDateUtil(list);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

//    @DeleteMapping("/{id}")
//    public Result delete(@PathVariable Integer id) {
//        remarkService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }

   /* @PutMapping
    public Result update(@RequestBody Remark remark) {
        remarkService.update(remark);
        return ResultGenerator.genSuccessResult();
    }*/


    /*@GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Remark> list = remarkService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }*/
}
