package com.yang.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.entity.User;
import com.yang.service.UserService;
import com.yang.util.DateReplaceUtil;
import com.yang.util.Result;
import com.yang.util.ResultGenerator;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
* @author Yyang
* @create 2018/01/04
*/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 注册后登陆
     * @param user
     * @param httpSession
     * @return
     */
    @PostMapping
    public Result add(User user, HttpSession httpSession) {
        //默认头像
        user.setImg("ing/user_img/head.jpg");
        userService.save(user);
        return userLogin(user, httpSession);
    }

    /**
     * 登陆 保存httpSession
     * @param user
     * @param httpSession
     * @return
     */
    @PostMapping("login")
    public Result userLogin(User user, HttpSession httpSession) {
        System.out.println("userLogin..."+
                "用户名:"+user.getNumber() +
                " 密码:" + user.getPassword());
        if (user.getNumber() == null || user.getPassword() == null) {
            return ResultGenerator.genFailResult("密码或用户名不能为空!");
        }
        //条件查询
        Condition condition = new Condition(User.class);
        condition.createCriteria()
                .andEqualTo("number", user.getNumber())
                .andEqualTo("password", user.getPassword());
        List<User> userResult = userService.findByCondition(condition);

        if (userResult.size() == 0 || null == userResult) {
            return ResultGenerator.genFailResult("密码或用户名错误!");
        }
        //保存用户id 评论拦截时使用
        httpSession.setAttribute("userid", userResult.get(0).getUserid());
        return ResultGenerator.genSuccessResult(userResult.get(0));
    }

    /**
     * 退出登陆
     * @param httpSession
     */
    @GetMapping("exit")
    public void exit(HttpSession httpSession) {
        httpSession.removeAttribute("userid");
    }

    /**
     * 检查用户名
     * @param nickname
     * @return
     */
    @PostMapping("/checkname")
    public Result checkname(String nickname) {
        System.out.println("checkname：" + nickname);
        if (null == nickname) {
            return ResultGenerator.genSuccessResult("用户名为空");
        }

        User user = userService.findBy("nickname", nickname);
        if (user == null) {
            return ResultGenerator.genSuccessResult("用户名可用");
        }else {
            return ResultGenerator.genFailResult("用户名已存在");
        }
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        DateReplaceUtil.dateUtil(list);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 按名称 手机号查询
     * @param name
     * @param page
     * @param size
     * @return
     */
    @GetMapping("name/{name}")
    public Result SelectUserName(@PathVariable("name") String name,
                                 @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        System.out.println(name);
        PageHelper.startPage(page, size);
        List<User> users = userService.selectByName(name);
        DateReplaceUtil.dateUtil(users);
        PageInfo<User> pageInfo = new PageInfo<>(users);

        return ResultGenerator.genSuccessResult(pageInfo);
    }


}
