/**
 * 包名称：com.example.springbootdemo.controller
 * 类名称：LoginAdminController
 * 类描述：管理员登录控制层
 * 创建人：@author 六叶草
 * 创建时间：2023年05月19日 16:11
 */
package com.example.springbootdemo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcelFactory;
import com.example.springbootdemo.common.PageUtils;
import com.example.springbootdemo.common.R;
import com.example.springbootdemo.controller.form.*;
import com.example.springbootdemo.service.SysCompanyService;
import com.example.springbootdemo.service.SysDeptService;
import com.example.springbootdemo.service.SysUserService;
import com.example.springbootdemo.units.SnSgUntils;
import com.example.springbootdemo.units.poi.ImportExcelUntil;
import com.example.springbootdemo.units.poi.ImportImgUntil;
import com.example.springbootdemo.units.poi.model.SysEmployeeMo;
import com.example.springbootdemo.units.poi.model.SysUserMo;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 创建人:  @author 六叶草
 * 创建时间:  2023年05月19日 16:11
 * 项目名称:  SpringBootDemo
 * 文件名称:  LoginAdminController
 * 文件描述:  @Description: 管理员登录控制层
 * 公司名称:  六叶草
 * <p>
 * All rights Reserved, Designed By 六叶草
 *
 * @Copyright: 2022-2023
 */
@RestController
@RequestMapping("/user")
@Tag(name = "UserController", description = "管理员Web接口")
public class UserController {

    //用户/员工业务接口
    @Autowired
    private SysUserService sysUserService;

    //部门业务接口
    @Autowired
    private SysDeptService sysDeptService;

    //所属公司业务接口
    @Autowired
    private SysCompanyService sysCompanyService;

    //导入Excel工具类及路径处理
    @Autowired
    private ImportExcelUntil importExcelUntil;

    //导入图片工具类
    @Autowired
    private ImportImgUntil importImgUntil;

    //导入图片工具类
    @Autowired
    private SnSgUntils snSgUntils;

    /**
     * @Author 六叶草
     * @Description //登录
     * @Date 2023/5/22 9:03
     **/
    @ApiOperation(value = "登录系统", notes = "获取登录用户信息")//给swagger添加说明信息
    @PostMapping("/login")
    public R login(@Valid @RequestBody LoginForm form) {
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        Integer userId = sysUserService.login(param);
        R r = R.ok().put("result", userId != null ? true : false);
        if (userId == null) {
            Integer num = sysUserService.selectUserNameExit(form.getUsername());
            if (num == 0) {
                r.put("msg", "用户名不存在！");
            } else {
                r.put("msg", "密码错误！");
            }
        }
        if (userId != null) {
            StpUtil.setLoginId(userId);
            Set<String> permissions = sysUserService.searchUserPermissions(userId);
            String token=StpUtil.getTokenInfo().getTokenValue();
            if (Boolean.FALSE.equals(form.getLoginCheck())) {
                StpUtil.login(userId,false);
            }
            r.put("permissions", permissions).put("token",token);
        }
        return r;
    }

    /**
     * @Author 六叶草
     * @Description //注册
     * @Date 2023/5/22 9:04
     **/
    @ApiOperation(value = "注册系统", notes = "获取注册用户信息")//给swagger添加说明信息
    @PostMapping("/register")
    public R register(@Valid @RequestBody RegisterForm form) {
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        Integer userId = sysUserService.register(param);
        R r = R.ok().put("result", userId == null ? true : false);
        //检查用户名和邮箱是否已注册
        if (userId != null) {
            Integer numUserName = sysUserService.selectUserNameExit(form.getUsername());
            Integer numEmail = sysUserService.selectEmailExit(form.getEmail());
            if (numUserName > 0) {
                r.put("msg", "用户名已注册！");
            } else if (numUserName == 0 && numEmail > 0) {
                r.put("msg", "邮箱已注册！");
            }
        }
        if (userId == null) {
            Integer num = sysUserService.insertUserPermissions(param);
            if (num > 0) {
                userId = sysUserService.register(param);
                StpUtil.setLoginId(userId);
                Set<String> permissions = sysUserService.searchUserPermissions(userId);
                String token=StpUtil.getTokenInfo().getTokenValue();
                r.put("permissions", permissions).put("token",token);
            }
        }
        return r;
    }

    /**
     * @Author 六叶草
     * @Description //登出系统
     * @Date 2023/6/21 15:07
     **/
    @GetMapping("/logout")
    @Operation(summary = "退出系统")
    public R logout() {
        StpUtil.logout();
        return R.ok();
    }

    /**
     * @Author 六叶草
     * @Description //修改密码
     * @Date 2023/6/2 19:07
     **/
    @PostMapping("/updatePassword")
    @SaCheckLogin
    @Operation(summary = "修改密码")
    public R updatePassword(@Valid @RequestBody UpdatePasswordForm from) {
        int userId = StpUtil.getLoginIdAsInt();
        HashMap param = new HashMap() {{
            put("userId", userId);
            put("password", from.getPassword());
        }};
        //更新密码
        int rows = sysUserService.updatePassword(param);
        StpUtil.logout();
        return R.ok().put("rows", rows);
    }

    /**
     * @Author 六叶草
     * @Description //首页下拉栏信息
     * @Date 2023/6/3 17:32
     **/
    @GetMapping("/selectUserInfo")
    @ApiOperation(value = "首页下拉栏信息", notes = "获取首页下拉栏信息")//给swagger添加说明信息
    @SaCheckPermission(value = {"ROOT", "USER:SEE"}, mode = SaMode.OR)
    public R loadSelectUserInfo() {
        //获取登录的用户id
        int userId = StpUtil.getLoginIdAsInt();
        //查询用户资料
        HashMap param = sysUserService.selectUserInfoHandle(userId);
        return R.ok().put("param",param);
    }

    /**
     * @Author 六叶草
     * @Description //更新个人资料
     * @Date 2023/6/4 11:15
     **/
    @PostMapping("/updateUserInfo")
    @SaCheckLogin
    @Operation(summary = "更新个人资料")
    public R updateUserInfo(@Valid @RequestBody UpdateUserInfoForm from) {
        int userId = StpUtil.getLoginIdAsInt();
        HashMap param = JSONUtil.parse(from).toBean(HashMap.class);
        param.put("userId", userId);
        //更新密码
        int rows = sysUserService.updateUserInfo(param);
        return R.ok().put("rows", rows);
    }

    /**
     * @Author 六叶草
     * @Description //上传图片
     * @Date 2023/6/4 11:15
     **/
    @PostMapping("/uploadPic")
    @SaCheckLogin
    @ApiOperation(value = "接收更新的图片", notes = "接收图片进行更新上传")//给swagger添加说明信息
    public R uploadPic(@RequestParam MultipartFile file, HttpServletRequest request) throws IOException {
        int userId = StpUtil.getLoginIdAsInt();
        String photo = sysUserService.searchPhotoById(userId);
        String fileName = importImgUntil.imgName(file);
        //返回可供外界访问的url
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/" + fileName;
        HashMap param = new HashMap(){{
            put("userId", userId);
            put("photo", url);
        }};
        int row = sysUserService.updateimg(param);
        if (row == 0) {
            return R.error("图片上传失败");
        }
        return R.ok("图片上传成功").put("photo",url);
    }

    /**
     * @Author 六叶草
     * @Description //查询员工管理的分页信息
     * @Date 2023/6/21 15:07
     **/
    @PostMapping("/searchEmployeeByPage")
    @Operation(summary = "查询员工管理的分页信息")
    @SaCheckPermission(value = {"ROOT", "EMPLOYEE:SEE"}, mode = SaMode.OR)
    public R searchEmployeeByPage(@Valid @RequestBody SearchEmployeeByPageForm form){
        int page= form.getPage();
        int length= form.getLength();
        int start=(page-1)*length;
        HashMap param= JSONUtil.parse(form).toBean(HashMap.class);
        param.put("start",start);
        if(!(StpUtil.hasPermission("ROOT")||StpUtil.hasPermission("EMPLOYEE:SELECT"))){
            param.put("userId",StpUtil.getLoginIdAsInt());
        }
        PageUtils pageUtils=sysUserService.searchEmployeeByPage(param);
        return R.ok().put("page",pageUtils);
    }

    @PostMapping("/deleteUserByIds")
    @Operation(summary = "删除用户记录")
    @SaCheckPermission(value = {"ROOT", "EMPLOYEE:DELETE"}, mode = SaMode.OR)
    public R deleteUserByIds(@Valid @RequestBody DeleteUserByIdsForm form) {
        int userId = StpUtil.getLoginIdAsInt();
        int rows = sysUserService.deleteUserByIds(form.getIds(),userId);
        return R.ok().put("rows", rows);
    }

    @PostMapping("/searchUserById")
    @Operation(summary = "查询用户管理的分页信息")
    @SaCheckPermission(value = {"ROOT", "EMPLOYEE:UPDATE"}, mode = SaMode.OR)
    public R searchUserById(@Valid @RequestBody SearchUserByIdForm form){
        HashMap params = sysUserService.searchUserById(form.getId());
        return R.ok().put("params", params);
    }

    /**
     * @Author 六叶草
     * @Description //查询用户管理的分页信息
     * @Date 2023/6/21 15:07
     **/
    @PostMapping("/searchUserByPage")
    @SaCheckPermission(value = {"ROOT", "USER:SELECT"}, mode = SaMode.OR)
    @ApiOperation(value = "查询用户管理的分页信息", notes = "查询用户管理的分页信息")//给swagger添加说明信息
    public R searchUserByPage(@Valid @RequestBody SearchUserByPageForm form){
        int page= form.getPage();
        int length= form.getLength();
        int start=(page-1)*length;
        HashMap param= JSONUtil.parse(form).toBean(HashMap.class);
        param.put("start",start);
        if(!(StpUtil.hasPermission("ROOT")||StpUtil.hasPermission("USER:SELECT"))){
            param.put("userId",StpUtil.getLoginIdAsInt());
        }
        PageUtils pageUtils=sysUserService.searchUserByPage(param);
        return R.ok().put("page",pageUtils);
    }

    /**
     * @Author 六叶草
     * @Description //注册为员工
     * @Date 2023/6/21 15:07
     **/
    @PostMapping("/userUpEmployee")
    @SaCheckPermission(value = {"ROOT", "USER:UPDATE"}, mode = SaMode.OR)
    @ApiOperation(value = "注册为员工", notes = "注册为员工")//给swagger添加说明信息
    public R userUpEmployee(@Valid @RequestBody UserUpEmployeeForm form){
        HashMap param= JSONUtil.parse(form).toBean(HashMap.class);
        if (form.getHiredate() == null) {
            SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
            Date date = new Date();// 获取当前时间
            param.put("hiredate", date);
        }
        int rows = sysUserService.updateUserUpEmployee(param);
        return R.ok("注册成功！").put("rows",rows);
    }

    @SaCheckPermission(value = {"ROOT", "USER:UPLOAD"}, mode = SaMode.OR)
    @ApiOperation(value = "导出全部用户数据Excel", notes = "导出Excel")//给swagger添加说明信息
    @GetMapping(value = "selectAllUserExcel")
    public R selectAllUserExcel() {
        List<HashMap> list = sysUserService.selectAllUserExcel();
        return R.ok().put("list",list);
    }

    @PostMapping("/uploadPicById")
    @SaCheckPermission(value = {"ROOT", "EMPLOYEE:UPDATE"}, mode = SaMode.OR)
    @ApiOperation(value = "根据用户Id接收更新的图片", notes = "根据用户Id接收更新的图片")//给swagger添加说明信息
    public R uploadPicById(@RequestParam MultipartFile file,@RequestParam Integer userId, HttpServletRequest request) throws IOException {
        String photo = sysUserService.searchPhotoById(userId);
        String fileName = importImgUntil.imgName(file);
        //返回可供外界访问的url
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/" + fileName;
        return R.ok("图片上传成功").put("photo",url);
    }
    @PostMapping("/uploadPicSaveById")
    @SaCheckPermission(value = {"ROOT", "USER:UPDATE","EMPLOYEE:UPDATE"}, mode = SaMode.OR)
    @ApiOperation(value = "根据用户Id接收更新的图片", notes = "根据用户Id接收更新的图片")//给swagger添加说明信息
    public R uploadPicSaveById(@RequestParam MultipartFile file,@RequestParam Integer userId, HttpServletRequest request) throws IOException {
        String photo = sysUserService.searchPhotoById(userId);
        String fileName = importImgUntil.imgName(file);
        //返回可供外界访问的url
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/" + fileName;

        HashMap param = new HashMap(){{
            put("userId", userId);
            put("photo", url);
        }};
        int row = sysUserService.updateimg(param);
        if (row == 0) {
            return R.error("图片上传失败");
        }
        return R.ok("图片上传成功").put("photo",url);
    }

    /**
     * @Author 六叶草
     * @Description //用于更新用户/员工表信息
     * @Date 2023/6/25 13:54
     **/
    @PostMapping("/updateEmployee")
    @SaCheckPermission(value = {"ROOT", "EMPLOYEE:UPDATE"}, mode = SaMode.OR)
    @ApiOperation(value = "根据用户Id更新员工信息", notes = "用于更新用户/员工表信息")//给swagger添加说明信息
    public R updateEmployee(@Valid @RequestBody UpdateEmployeeForm form) {
        HashMap param=JSONUtil.parse(form).toBean(HashMap.class);
        param.replace("role",JSONUtil.parseArray(form.getRole()).toString());
        //检查用户名和邮箱是否已注册
        Integer numUserName = sysUserService.selectUserNameCheck(form.getUsername(),form.getUserId());
        Integer numEmail = sysUserService.selectEmailExitCheck(form.getEmail(),form.getUserId());
        if (numUserName > 0) {
            return R.error("用户名已存在！");
        } else if (numUserName == 0 && numEmail > 0) {
            return R.error("邮箱已存在！");
        }
        int rows=sysUserService.updateEmployee(param);
        if(rows==1){
            StpUtil.logoutByLoginId(form.getUserId());
        }
        return R.ok().put("rows",rows).put("msg","更新成功！");
    }

    /**
     * @Author 六叶草
     * @Description //用于添加用户/员工表信息
     * @Date 2023/6/25 13:55
     **/
    @PostMapping("/insertEmployee")
    @SaCheckPermission(value = {"ROOT", "EMPLOYEE:INSERT"}, mode = SaMode.OR)
    @ApiOperation(value = "添加员工信息", notes = "用于添加用户/员工表信息")//给swagger添加说明信息
    public R insertEmployee(@Valid @RequestBody InsertEmployeeForm form) {
        HashMap param=JSONUtil.parse(form).toBean(HashMap.class);
        //查询最大的code
        String code = sysUserService.searchMaxCode();
        //包含年月日
        //SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        //Date date = new Date();
        //String dateTime = sdf.format(date);
        String newCode = snSgUntils.sfGenNum(code,null,4);
        param.put("code", newCode);
        param.replace("role",JSONUtil.parseArray(form.getRole()).toString());
        //检查用户名和邮箱是否已注册
        Integer numUserName = sysUserService.selectUserNameExit(form.getUsername());
        Integer numEmail = sysUserService.selectEmailExit(form.getEmail());
        if (numUserName > 0) {
            return R.error("用户名已存在！");
        } else if (numUserName == 0 && numEmail > 0) {
            return R.error("邮箱已存在！");
        }
        int rows = sysUserService.insertEmployee(param);
        return R.ok().put("rows",rows).put("msg","新增成功！");
    }

    @SaCheckPermission(value = {"ROOT", "EMPLOYEE:UPLOAD"}, mode = SaMode.OR)
    @ApiOperation(value = "导出全部员工数据Excel", notes = "导出Excel")//给swagger添加说明信息
    @GetMapping(value = "selectAllEmployeeExcel")
    public R selectAllEmployeeExcel() {
        List<HashMap> list = sysUserService.selectAllEmployeeExcel();
        return R.ok().put("list",list);
    }

    @PostMapping("/uploadUserExcel")
    @SaCheckLogin
    @ApiOperation(value = "接收上传的Excel文件（用户）", notes = "接收上传的Excel文件（用户）")//给swagger添加说明信息
    public R uploadUserExcel(@RequestParam MultipartFile file) throws FileNotFoundException {
        String filePath = importExcelUntil.excelName(file);
        if (filePath == "文件类型不对") {
            return R.ok(filePath).put("result",false);
        } else if (filePath.indexOf("系统异常")!=-1) {
            return R.ok(filePath).put("result",false);
        }
        FileInputStream inputStream = new FileInputStream(filePath);
        // 1.自定义一个工具类拿到要解析的文件并解析成要存储的数据
        List<SysUserMo> list = EasyExcelFactory.read(inputStream).head(SysUserMo.class).sheet().doReadSync();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername() == null || list.get(i).getEmail() == null || list.get(i).getTel() == null) {
                return R.ok("用户名、电子邮箱、手机号码可能存在空值，请检查！").put("result",false);
            }
            //检查用户名和邮箱是否已注册
            Integer numUserName = sysUserService.selectUserNameExit(list.get(i).getUsername());
            Integer numEmail = sysUserService.selectEmailExit(list.get(i).getEmail());
            if (numUserName > 0) {
                return R.ok("有用户名已存在数据库中，请检查！").put("result",false);
            } else if (numUserName == 0 && numEmail > 0) {
                return R.ok("有邮箱已存在数据库中，请检查！").put("result",false);
            }
        }
        int rows = sysUserService.insertUsers(list);
        if (rows < 1) {
            return R.ok("上传失败！").put("result",false);
        }
        return R.ok("上传成功!").put("rows", rows).put("result",true);
    }

    @PostMapping("/uploadEmployeeExcel")
    @SaCheckLogin
    @ApiOperation(value = "接收上传的Excel文件（员工）", notes = "接收上传的Excel文件（员工）")//给swagger添加说明信息
    public R uploadEmployeeExcel(@RequestParam MultipartFile file) throws FileNotFoundException {
        String filePath = importExcelUntil.excelName(file);
        if (filePath == "文件类型不对") {
            return R.ok(filePath).put("result",false);
        } else if (filePath.indexOf("系统异常")!=-1) {
            return R.ok(filePath).put("result",false);
        }
        FileInputStream inputStream = new FileInputStream(filePath);
        // 1.自定义一个工具类拿到要解析的文件并解析成要存储的数据
        List<SysEmployeeMo> list = EasyExcelFactory.read(inputStream).head(SysEmployeeMo.class).sheet().doReadSync();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername() == null || list.get(i).getEmail() == null || list.get(i).getTel() == null
                    || list.get(i).getDeptName() == null || list.get(i).getCompanyName() == null || list.get(i).getHiredate() == null) {
                return R.ok("用户名、电子邮箱、手机号码、部门、所属公司、入职日期可能存在空值，请检查！").put("result",false);
            }
            //检查用户名和邮箱是否已注册
            Integer numUserName = sysUserService.selectUserNameExit(list.get(i).getUsername());
            Integer numEmail = sysUserService.selectEmailExit(list.get(i).getEmail());
            if (numUserName > 0) {
                return R.ok("有用户名已存在数据库中，请检查！").put("result",false);
            } else if (numUserName == 0 && numEmail > 0) {
                return R.ok("有邮箱已存在数据库中，请检查！").put("result",false);
            }
            Integer numDeptName = sysDeptService.selectDeptByName(list.get(i).getDeptName());
            if (numDeptName == 0) {
                return R.ok("有部门不存在于数据库中，请检查！").put("result",false);
            }
            Integer numCompanyName = sysCompanyService.selectCompanyByName(list.get(i).getCompanyName());
            if (numCompanyName == 0) {
                return R.ok("有所属部门不存在于数据库中，请检查！").put("result",false);
            }
        }
        int rows = sysUserService.insertEmployees(list);
        if (rows < 1) {
            return R.ok("上传失败！").put("result",false);
        }
        return R.ok("上传成功!").put("rows", rows).put("result",true);
    }
}
