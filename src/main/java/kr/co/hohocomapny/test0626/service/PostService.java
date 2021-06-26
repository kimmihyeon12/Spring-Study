package kr.co.hohocomapny.test0626.service;

import kr.co.hohocomapny.test0626.domain.Post;
import kr.co.hohocomapny.test0626.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void write(Post post) throws Exception {
        postRepository.save(post);
    }

    public List<Post> getPosts() throws Exception {
        return postRepository.findAll();
    }
}
