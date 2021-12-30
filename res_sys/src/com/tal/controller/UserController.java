package com.tal.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tal.domain.Category;
import com.tal.domain.Product;
import com.tal.domain.User;
import com.tal.service.CategoryService;
import com.tal.service.ProductService;
import com.tal.service.UserService;
import com.tal.utils.Constract;

//在配置文件中指定扫描的Controller包中创建类，并添加@Controller注解，这就是一个Controller类
@SessionAttributes( Constract.CURRENT_USER )//本类中所有方法中保存到Model中的名为current_user的对象，都保存到Session域中
@Controller
public class UserController {
    //本类依赖的对象的引用，一定要用接口类型（降低耦合度）
    @Autowired//Spring框架提供的自动装配的注解
    private UserService userService;//此对象由Spring框架创建并注入

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;


    //处理日期类型的转换问题，否则会报400错误 
    @InitBinder
    public void initBinder( WebDataBinder binder ){
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor( sdf , true));
    }


    //转跳到首页的方法
    @RequestMapping("/index")//注意：此路径是访问此方法的路径，因为是服务端路径所以不带项目名
    public String goIndex( HttpServletRequest req ){
        //转跳首页之前，取得所有分类信息，用于在导航条上显示
        List<Category> list = (List<Category>)req.getServletContext().getAttribute("all_categorys");

        //判断此集合对象是否为null，如果为null说明是第一次访问，ServletContext域中还没有分类信息，则从数据库取得，并保存
        if( list == null ){
            //调用业务逻辑，取得所有分类
            list = categoryService.findAll();
            //保存到ServletContext域中，注意名字和取的时候保持一致
            req.getServletContext().setAttribute("all_categorys", list);
        }

        //取得9个最新商品和9个热门商品，在首页中显示
        List<Product> hots = productService.findHotProducts();
        List<Product> news = productService.findNewProducts();

        //保存到Request域
        req.setAttribute("hotProducts", hots);
        req.setAttribute("newProducts", news);

        //方法返回的字符串，就是要转跳到的页面。
        return "index";//转跳到：/WEB-INF/jsp/index.jsp
    }

    //转跳到注册页面
    @RequestMapping("/goRegister")
    public String toRegister(){
        //转跳到/WEB-INF/jsp/register.jsp
        return "register";
    }

    //进行注册
    @RequestMapping("/register")
    //SpringMVC提供了Model参数可以用于在页面间传递数据
    public String register( User user , Model model ){//接收提交的用户信息，并封装成User对象

        //调用业务逻辑，进行注册
        userService.registUser(user);

        //通过Model对象把名为msg的字符串带到页面。
        model.addAttribute("msg", "注册成功！");

        return "info";
    }




    //转跳到登录页面
    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    //登录验证
    @RequestMapping("/login")
    public String login( String username , String password , Model model ){
        //根据返回的用户对象是否为null，判断登录是否成功
        User user = userService.checkLogin(username, password);

        String result;
        if( user == null ){
            //登录失败，则在信息页面显示“登录失败”
            model.addAttribute("msg","登录失败，请重新登录。");
            result = "info";//转跳到info页面
        }else{
            //登录成功，则把用户对象保存到Session中，并转跳到首页，
            model.addAttribute( Constract.CURRENT_USER , user);//因为类上的面SessionAttrubtes注解的设置，此对象保存到Session域
            result = "/index";//返回的路径前面加redirect，此转跳的方式为重定向
        }

        return result;
    }

}
