package alex.controller;

import alex.model.Post;
import alex.model.User;
import alex.service.IPostService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by alex on 16-4-5.
 */


@Controller
@RequestMapping("/post")
public class PostController {
    @Resource(name = "postService")
    private IPostService postService;

    @RequestMapping(value="/submitPost", method= RequestMethod.POST)
    @ResponseBody
    public String submitPost(@ModelAttribute("post")Post post, HttpSession httpSession){
        System.out.println(post.getContent());
        post.setUser((User)httpSession.getAttribute("user"));
        //check limitation of tweet 140 characters
        return "OK OK";
    }



    @RequestMapping(value="/homePage", method=RequestMethod.GET)
    public ModelAndView homePage(HttpSession session){
        User user = (User)session.getAttribute("user");
        List<Post> posts = null;
        if(user != null){
             posts = postService.getFollowPost(user.getId());
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("posts", posts);
        if(posts == null){
            System.out.println("null list");
        }
        mv.setViewName("/keijiban/homepage");
        return mv;
    }
}
