package cau.ict.btrack_week6.service;

import cau.ict.btrack_week6.converter.PostConverter;
import cau.ict.btrack_week6.dto.NewPostDto;
import cau.ict.btrack_week6.dto.PostDto;
import cau.ict.btrack_week6.entity.Member;
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

    public Long createPost(String title, String body, Member member) {
        NewPostDto newPostDto = new NewPostDto(title, body, member);
        Post post = PostConverter.toPost(newPostDto);
        postRepository.save(post);
        return post.getId();
    }

    public PostDto readOneByTitle(String postTitle) {
        Optional<Post> findPost = postRepository.findByTitle(postTitle);
        if (findPost.isEmpty()) {
            log.warn("There is no post.");
            return null;
        } else {
            return PostDto.of(findPost.get());
        }
    }

    public PostDto readOneByMember(Member member) {
        Optional<Post> findPost = postRepository.findByMemberId(member.getId());
        if (findPost.isEmpty()) {
            log.warn("There is no post.");
            return null;
        } else {
            return PostDto.of(findPost.get());
        }
    }

    public Post readOneById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            return post.get();
        } else throw new RuntimeException();
    }

    public List<Post> readAll() {
        return postRepository.findAll();
    }

    public void updatePost(Long id, String newTitle, String newBody) {
        Optional<Post> findPost = postRepository.findById(id);
        if (findPost.isPresent()) {
            findPost.get().update(newTitle, newBody);
            postRepository.save(findPost.get());
        }
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
