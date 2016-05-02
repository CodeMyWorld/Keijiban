package alex.controller;

import alex.model.Post;
import alex.model.User;
import alex.service.IPostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by alex on 16-4-5.
 */


@Controller
@RequestMapping("/")
public class PostController {
    @Resource(name = "postService")
    private IPostService postService;

    @RequestMapping(value="/submitPost", method= RequestMethod.POST)
    @ResponseBody
    public String submitPost(@ModelAttribute("post")Post post, HttpSession httpSession){
        System.out.println(post.getContent());
        post.setUser((User)httpSession.getAttribute("user"));
        String nickname = post.getNickname();
        httpSession.setAttribute("nickname", nickname);
        postService.create(post);
        //check limitation of tweet 140 characters
        return "OK OK";
    }



    @RequestMapping(value="/homePage/{page}", method=RequestMethod.GET)
    public ModelAndView homePage(HttpSession session, @PathVariable Integer page){
        User user = (User)session.getAttribute("user");
        List<Post> posts = null;
        int pages=0;
        if(user != null){
             posts = postService.getFollowPost(user.getId(),page);
             pages=postService.getPage(user.getId());
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("posts", posts);
        mv.addObject("pages", pages);
        mv.addObject("current",page);
        if(posts == null){
            System.out.println("null list");
        }
        mv.setViewName("homepage");
        return mv;
    }
}
