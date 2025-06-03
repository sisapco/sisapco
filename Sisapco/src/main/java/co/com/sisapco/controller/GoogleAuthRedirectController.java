package co.com.sisapco.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.stream.Stream;

@Controller
public class GoogleAuthRedirectController {

   

    @RequestMapping("/Callback")
    public String callbackUrl(
            HttpServletRequest request,
            HttpSession httpSession) {
        String code = request.getParameter("code");
        String accessDenied = request.getParameter("access_denied") == null
                ? "" : request.getParameter("access_denied");
       
        return "redirect:/files";
    }
}