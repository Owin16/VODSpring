package owin.vod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import owin.vod.logic.ListLogic;
import owin.vod.logic.ListLogicImpl;
import owin.vod.model.Account;
import owin.vod.model.User;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerUser {

    /*@Autowired
    private ListLogic listLogic;*/

    @RequestMapping(value = "/")
    public String index() {

        return "/index";
    }


    @RequestMapping(value = "/getSum", method = RequestMethod.POST)
    public String setSum(@ModelAttribute("mvc-dispatcher") Account account,
                         ModelMap model) {
        ListLogicImpl listLogicImpl = new ListLogicImpl();
        model.addAttribute("sum", listLogicImpl.getSum());


        return "/index";
    }

    @RequestMapping(value = "/getRichest", method = RequestMethod.POST)
    public String setSum(@ModelAttribute("mvc-dispatcher")  User user,
                         ModelMap model) {
        ListLogicImpl listLogicImpl = new ListLogicImpl();
        model.addAttribute("user", listLogicImpl.getRichestUser());


        return "/index";
    }
}
