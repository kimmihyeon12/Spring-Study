package kr.co.hohocomapny.test0626.repository;

import kr.co.hohocomapny.test0626.domain.Post;

import java.util.List;

public interface PostRepository {
    void save(Post post) throws Exception;

    List<Post> findAll() throws Exception;
}
