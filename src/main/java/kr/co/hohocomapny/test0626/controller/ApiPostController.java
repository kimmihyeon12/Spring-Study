package kr.co.hohocomapny.test0626.controller;

import kr.co.hohocomapny.test0626.domain.Post;
import kr.co.hohocomapny.test0626.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class ApiPostController {

    private final PostService postService;

    @Autowired
    public ApiPostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/api")
    public String index(){
        return "singlePage/index";
    }

    @GetMapping("/api/posts")
    @ResponseBody
    public List<Post> getPosts() throws Exception {
        return postService.getPosts();
    }
}
