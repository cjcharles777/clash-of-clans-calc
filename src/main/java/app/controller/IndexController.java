package app.controller;

/**
 * Created by cedric on 12/3/14.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SuppressWarnings("UnusedDeclaration")
public class IndexController {

    @Value("${example.message}")
    private String message;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index()
    {
        return new ModelAndView("index");
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home()
    {
        return new ModelAndView("index");
    }
}
