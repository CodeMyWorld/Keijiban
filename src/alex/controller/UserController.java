package alex.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import alex.model.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import alex.model.User;
import alex.service.IUserService;

import java.util.List;


@Controller
@RequestMapping("/")
public class UserController {

	@Resource(name = "userService")
	private IUserService userService;

	@RequestMapping(value="register", method=RequestMethod.GET)
	public ModelAndView getRegister(){
		ModelAndView mView = new ModelAndView();
//        User user = userService.findOne(1);
//        mView.addObject("user", user);
		mView.setViewName("user/register");
		return mView;
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("user") User user){
		userService.create(user);
		ModelAndView mView = new ModelAndView();
		user = userService.findOne(1);
        mView.addObject("user", user);
		mView.setViewName("user/detail");
		return mView;
	}

	@RequestMapping(value="show/{id}", method=RequestMethod.GET)
	public ModelAndView showDetail(@PathVariable Integer id){
		User user = userService.findOne(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/detail");
		mv.addObject("user", user);
		System.out.println("bug");
		return mv;
	}

	@RequestMapping(value="test", method=RequestMethod.GET)
	public ModelAndView getHello(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/hello");
		return mv;
	}

	@RequestMapping(value="login", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(HttpSession httpSession, @ModelAttribute("user") User user){
		User loginUser = userService.login(user);
		if(loginUser != null){
			httpSession.setAttribute("user", loginUser);
			System.out.println(user.getUsername());
			return new ModelAndView("redirect:/homePage/1");
		}
		return new ModelAndView("error");
	}

	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ModelAndView searchUser(String keyword){
		List<User> result = userService.search(keyword);
		for(User user : result){
			System.out.println(user.getUsername());
		}
		return null;
	}

	@RequestMapping(value="logout", method=RequestMethod.GET)
	public ModelAndView login(HttpSession httpSession){
		httpSession.removeAttribute("user");
		httpSession.removeAttribute("nickname");
		return new ModelAndView("redirect:/index");
	}

	@RequestMapping(value="getsession", method = RequestMethod.GET)

	public ResponseEntity<Session> getSession(HttpSession session){
		String nickname;
		if(session.getAttribute("nickname") != null){
			nickname = session.getAttribute("nickname").toString();
		}else {
			nickname = null;
		}
		Session result = new Session(((User)session.getAttribute("user")).getUsername(),nickname);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value="/index", method = RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("index");
	}
}
