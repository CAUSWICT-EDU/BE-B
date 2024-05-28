package cau.ict.btrack_week6.service;

import cau.ict.btrack_week6.dto.PostDto;
import cau.ict.btrack_week6.entity.Post;
import cau.ict.btrack_week6.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;

    public void createPost() {

    }

    public PostDto readOnePost(String postTitle) {
        Optional<Post> findPost = postRepository.findByTitle(postTitle);
        if (findPost.isEmpty()) {
            log.warn("There is no post.");
            return null;
        } else {
            return PostDto.of(findPost.get());
        }

    }

    public List<Post> readAllPost() {
        return postRepository.findAll();
    }

    public void updatePost() {

    }

    public void deletePost() {

    }
}
