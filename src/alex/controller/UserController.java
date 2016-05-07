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
	
	@RequestMapping(value="register", method = RequestMethod.POST)

	public @ResponseBody String add(String username,String password,
									 String confirmPass){
		System.out.println(username+" "+password);
		if(password.equals(confirmPass)){
			if(userService.register(username, password) != null){
				return "success";
			}else {
				return "exist";
			}
		}
		return "passerror";
	}

	@RequestMapping(value="login", method=RequestMethod.POST)
	@ResponseBody
	public String login(HttpSession httpSession, @ModelAttribute("user") User user){
		System.out.println("hello login");
		System.out.println(user.getUsername()+" "+user.getPassword());
		User loginUser = userService.login(user);
		if(loginUser != null){
			httpSession.setAttribute("user", loginUser);
			System.out.println(user.getUsername());
			return "success";
		}
		return "error";
	}

	@RequestMapping(value="search", method=RequestMethod.GET)
	public ModelAndView searchUser(String keyword, HttpSession session){
		User currentUser = (User)session.getAttribute("user");
		List<User> result = userService.search(keyword, currentUser.getId());
		for(User user : result){
			System.out.println(user.getUsername());
		}
		ModelAndView mv = new ModelAndView("search");
		mv.addObject("result", result);
		return mv;
	}

	@RequestMapping(value="logout", method=RequestMethod.GET)
	public ModelAndView login(HttpSession httpSession){
		httpSession.removeAttribute("user");
		httpSession.removeAttribute("nickname");
		return new ModelAndView("redirect:/index");
	}

	@RequestMapping(value="follow", method = RequestMethod.GET)
	@ResponseBody
	public String following(HttpSession httpSession, Integer userId){
		System.out.println(userId);
		User user = (User)httpSession.getAttribute("user");
		userService.follow(user,userId);
		return "OK";
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

	@RequestMapping(value="following", method = RequestMethod.GET)
	public ModelAndView getFollowing(HttpSession session){
		User user = (User)session.getAttribute("user");
		List<User> result = userService.getFollowing(user.getId());
		ModelAndView mv = new ModelAndView("following");
		mv.addObject("result", result);
		return mv;
	}

	@RequestMapping(value="unfollow", method = RequestMethod.GET)
	@ResponseBody
	public String unfollowing(HttpSession httpSession, int followId){
		User user = (User)httpSession.getAttribute("user");
		userService.unfollow(user.getId(), followId);
		return "OK";
	}

	@RequestMapping(value="index", method = RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("index");
	}
}
