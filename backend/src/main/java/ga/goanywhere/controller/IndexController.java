package ga.goanywhere.controller;

import ga.goanywhere.dao.UserEntity;
import ga.goanywhere.model.SessionFactoryUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/db")
    public @ResponseBody List<UserEntity> db(){
        Session session = SessionFactoryUtil.getSession();
        session.beginTransaction();
        List response = session.createQuery("from UserEntity").list();
        session.getTransaction().commit();
        session.close();
        return response;
    }

}
