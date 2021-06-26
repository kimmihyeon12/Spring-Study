package kr.co.hohocomapny.test0626.repository;

import kr.co.hohocomapny.test0626.domain.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.lang.reflect.Member;
import java.util.List;

@Repository
public class JpaPostRepository implements PostRepository{

    private final EntityManager entityManager;

    public JpaPostRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Post post) throws Exception {
        entityManager.persist(post);
    }

    @Override
    public List<Post> findAll() throws Exception {
        return entityManager.createQuery("select p from Post p", Post.class).getResultList();

    }
}
