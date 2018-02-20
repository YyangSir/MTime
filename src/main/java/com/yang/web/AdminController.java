package com.yang.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.entity.Admin;
import com.yang.service.AdminService;
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
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @PostMapping
    public Result add(Admin admin) {
        adminService.save(admin);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        adminService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Admin admin) {
        adminService.update(admin);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Admin admin = adminService.findById(id);
        return ResultGenerator.genSuccessResult(admin);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Admin> list = adminService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 管理员登陆
     * @param admin
     * @param httpSession
     * @return
     */
    @PostMapping("login")
    public Result adminLogin(Admin admin,HttpSession httpSession) {
        System.out.println("adminLogin..." +
                "管理员:" + admin.getName() +
                "密码:" + admin.getPassword());
        //条件查询
        Condition condition = new Condition(Admin.class);
        condition.createCriteria()
                .andEqualTo("name",admin.getName())
                .andEqualTo("password", admin.getPassword());
        List<Admin> adminResult = adminService.findByCondition(condition);

        if (adminResult.size() == 0 || null == adminResult) {
            return ResultGenerator.genFailResult("密码或用户名错误!");
        }
        //保存管理员权限
        httpSession.setAttribute("admin", adminResult.get(0).getPrivilege());
        return ResultGenerator.genSuccessResult(adminResult);
    }

    /**
     * 退出登陆
     * @param httpSession
     */
    @GetMapping("exit")
    public void exit(HttpSession httpSession) {
        httpSession.removeAttribute("admin");
    }
}
