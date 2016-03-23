package alex.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import alex.model.User;
import alex.service.IUserService;



@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name = "userService")
	private IUserService userService;

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView getRegister(){
		ModelAndView mView = new ModelAndView();
//        User user = userService.findOne(1);
//        mView.addObject("user", user);
		mView.setViewName("user/register");
		return mView;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("user") User user){
		userService.create(user);
		ModelAndView mView = new ModelAndView();
		user = userService.findOne(1);
        mView.addObject("user", user);
		mView.setViewName("user/detail");
		return mView;
	}

	@RequestMapping(value="/show/{id}", method=RequestMethod.GET)
	public ModelAndView showDetail(@PathVariable Integer id){
		User user = userService.findOne(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/detail");
		mv.addObject("user", user);
		System.out.println("bug");
		return mv;
	}

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public ModelAndView getHello(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/hello");
		return mv;
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(HttpSession httpSession, @ModelAttribute("user") User user){
		boolean check = userService.login(user);
		System.out.println(check);
		return null;
	}
}
