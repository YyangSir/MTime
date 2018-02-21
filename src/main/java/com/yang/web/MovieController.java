package com.yang.web;

import com.yang.entity.Movie;
import com.yang.service.MovieService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.util.Result;
import com.yang.util.ResultGenerator;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
* @author Yyang
* @create 2018/01/05
*/
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Resource
    private MovieService movieService;

    @PostMapping
    public Result add(Movie movie) {
        movieService.save(movie);
        return ResultGenerator.genSuccessResult("电影信息上传成功");
    }

    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable String id) {
        movieService.deleteById(Integer.parseInt(id));
        return ResultGenerator.genSuccessResult("电影删除成功");
    }

    @PutMapping
    public Result update(Movie movie) {
        movieService.update(movie);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Movie movie = movieService.findById(id);
        return ResultGenerator.genSuccessResult(movie);
    }

    /**
     * 查询所有电影
     * @param page
     * @param size
     * @return
     */
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        System.out.println("page:" + page + "," + "size:" + size);
        //添加条件 按id倒序查询
        Condition condition = new Condition(Movie.class);
        condition.setOrderByClause("movieId desc");

        PageInfo pageInfo = new PageInfo(selectMovieList(page, size, condition));

        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 最近的电影
     * @param page
     * @param size
     * @return
     */
    @GetMapping("recent")
    public Result recentList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "8") Integer size) {
        System.out.println("page:" + page + "," + "size:" + size);
        //获取时间上个月到当前时间
        //Calendar.MONTH 从0开始计数 即Calendar.MONTH+1为当前月
        Calendar c = Calendar.getInstance();
        String endTime = String.valueOf(c.get(Calendar.YEAR))+"-"+
                (c.get(Calendar.MONTH)+1)+"-"+
                c.get(Calendar.DATE);
        String startTime = String.valueOf(c.get(Calendar.YEAR))+"-"+
                c.get(Calendar.MONTH)+"-"+
                c.get(Calendar.DATE);
        System.out.println(startTime+" "+endTime);

        Condition condition = new Condition(Movie.class);
        condition.setOrderByClause("movieId desc");
        condition.createCriteria().andBetween("time", "2018-01-01", "2018-02-20");

        PageInfo pageInfo = new PageInfo(selectMovieList(page, size, condition));
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 即将上映的电影
     * @param page
     * @param size
     * @return
     */
    @GetMapping("upcoming")
    public Result upcoming(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "4") Integer size) {
        //获取时间 当前时间到下一个月
        Calendar c = Calendar.getInstance();
        String endTime = String.valueOf(c.get(Calendar.YEAR))+"-"+
                (c.get(Calendar.MONTH)+2)+"-"+
                c.get(Calendar.DATE);
        String startTime = String.valueOf(c.get(Calendar.YEAR))+"-"+
                (c.get(Calendar.MONTH)+1)+"-"+
                c.get(Calendar.DATE);
        System.out.println(startTime+" "+endTime);

        Condition condition = new Condition(Movie.class);
        condition.setOrderByClause("movieId desc");
        condition.createCriteria().andBetween("time", "2017-12-01", "2018-02-01");

        PageInfo pageInfo = new PageInfo(selectMovieList(page, size, condition));

        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 根据不同条件查询电影列表
     * @param page
     * @param size
     * @param condition
     * @return
     */
    private List<Movie> selectMovieList(Integer page, Integer size,Condition condition) {
        PageHelper.startPage(page, size);
        List<Movie> list = movieService.findByCondition(condition);
        //去除年份 titleCn中年份
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setTitlecn(
                    list.get(i).getTitlecn().substring(
                            0, list.get(i).getTitlecn().length()-6));
        }

        return list;
    }

}
