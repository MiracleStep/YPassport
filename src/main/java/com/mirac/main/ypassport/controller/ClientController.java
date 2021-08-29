package com.mirac.main.ypassport.controller;

import com.mirac.main.ypassport.config.JwtProperties;
import com.mirac.main.ypassport.dao.DBMapper;
import com.mirac.main.ypassport.pojo.*;
import com.mirac.main.ypassport.utils.CookieUtils;
import com.mirac.main.ypassport.utils.JwtUtils;
import com.mirac.main.ypassport.utils.RsaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
@EnableConfigurationProperties(JwtProperties.class)
public class ClientController {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private DBMapper dbMapper;

    @RequestMapping("/")
    public String getLoginView(){
        return "authentication-signin";
    }

    @RequestMapping("/login")
    public String login(User user, HttpServletResponse response, HttpServletRequest request){
        User res = dbMapper.findUserByUsernameAndPassword(user);
        if(res == null || res.getUsername()==null){
            return "authentication-signin";
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(res.getUsername());
        userInfo.setId((long) res.getId());
        PrivateKey privateKey = this.jwtProperties.getPrivateKey();

        try {
            String token = JwtUtils.generateToken(userInfo, privateKey, this.jwtProperties.getExpire());
            CookieUtils.setCookie(request,response,jwtProperties.getCookieName(),token,jwtProperties.getExpire()*60);
            if(res.getRank()==1){
                return "redirect:/company/all";
            }else{
                return "redirect:/point/"+user.getId();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:authentication-signin";
        }

    }
    @RequestMapping("/point/{id}")
    public String getMainData(@PathVariable("id")String id, Model model,HttpServletRequest request){
        try {
            String token = CookieUtils.getCookieValue(request,"YP_TOKEN");
            if(token==null || token.equals("")){
                return "authentication-signin";
            }
            UserInfo userInfo = JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
            //ConfigUtils.Recipel_Contract = new Recipel(ConfigUtils.Recipel_Address, ConfigUtils.WEB3_J, ConfigUtils.USER_Credentials, ConfigUtils.GAS_PRICE, ConfigUtils.GAS_LIMIT);
            List<Point> point = dbMapper.findById(id);
            Field[] fields = Point.class.getDeclaredFields();
            List list = new ArrayList<String>();
            for (int i = 0; i < fields.length; i++) {
                list.add(fields[i].getName());
            }
            model.addAttribute("attr",list);
            model.addAttribute("user",userInfo.getUsername());
            model.addAttribute("point", point);
            return "index1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "authentication-signin";
    }

    @RequestMapping("/company/all")
    public String getCompanyAll(Model model,HttpServletRequest request){
        try {
            String token = CookieUtils.getCookieValue(request,"YP_TOKEN");
            if(token==null || token.equals("")){
                return "authentication-signin";
            }
            UserInfo userInfo = JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
            List<Wuliu> wuliu = dbMapper.findAllWuliu();
            List<Jiezhongren> jiezhongren = dbMapper.findAllJiezhongren();
            List<Point> point = dbMapper.findAllPoint();
            model.addAttribute("wuliu",wuliu);
            model.addAttribute("user",userInfo.getUsername());
            model.addAttribute("jiezhongren",jiezhongren);
            model.addAttribute("point",point);
            return "index2";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "authentication-signin";
    }
}
