package kr.co.hohocomapny.test0626.controller;

import kr.co.hohocomapny.test0626.domain.Post;
import kr.co.hohocomapny.test0626.dto.PostForm;
import kr.co.hohocomapny.test0626.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PagePostController {

    private final PostService postService;

    @Autowired
    public PagePostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String home(Model model) throws Exception {

       List<Post> posts = postService.getPosts();
       model.addAttribute("posts", posts);

       return "multiPage/home";
    }

    @GetMapping("/posts/create")
    public String createPost(){
        return "multiPage/create";
    }

    @PostMapping("/posts")
    public String createPost(PostForm postForm) throws Exception {

        Post post = new Post();
        post.setTitle(postForm.getTitle());
        post.setDesc(postForm.getDescription());
        post.setWriter(postForm.getWriter());

        postService.write(post);

        return "redirect:/";
    }
}
