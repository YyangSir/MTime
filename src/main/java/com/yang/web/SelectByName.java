package com.yang.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.entity.Actor;
import com.yang.entity.Movie;
import com.yang.service.ActorService;
import com.yang.service.MovieService;
import com.yang.util.Result;
import com.yang.util.ResultGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yyang
 * @create 2018/1/22.
 */
@RestController
public class SelectByName {
	@Resource
	private MovieService movieService;
	@Resource
	private ActorService actorService;

	@GetMapping("/movieName/{name}")
	public Result selectMovie(@PathVariable("name") String name,
							  @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "12") Integer size) {
		System.out.println(name);

		if (name == null) {
			return ResultGenerator.genFailResult("搜索内容不能为空");
		}
		PageHelper.startPage(page, size);
		List<Movie> movies = movieService.selectByName(name);
		PageInfo pageInfo = new PageInfo(movies);

		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@GetMapping("/actorName/{name}")
	public Result selectActor(@PathVariable("name") String name,
							  @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "12") Integer size) {
		System.out.println(name);

		PageHelper.startPage(page, size);
		List<Actor> actors = actorService.selectByName(name);
		PageInfo pageInfo = new PageInfo(actors);

		return ResultGenerator.genSuccessResult(pageInfo);
	}
}
