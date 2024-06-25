package cau.ict.btrack_week6.service;

import cau.ict.btrack_week6.apiPayload.code.status.ErrorStatus;
import cau.ict.btrack_week6.apiPayload.exception.GeneralException;
import cau.ict.btrack_week6.converter.PostConverter;
import cau.ict.btrack_week6.dto.NewPostDto;
import cau.ict.btrack_week6.dto.PostDto;
import cau.ict.btrack_week6.entity.Member;
import cau.ict.btrack_week6.entity.Post;
import cau.ict.btrack_week6.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;

    private Post findPostByIdOrThrow(Long postId) { //postId로 post를 찾아오고, 찾지 못한 경우 Error를 발생시키는 함수
        Optional<Post> post = postRepository.findById(postId);
        return post.orElseThrow(() -> new GeneralException(ErrorStatus.POST_NOT_FOUND));
    }

    public Long createPost(String title, String body, Member member) {
        NewPostDto newPostDto = new NewPostDto(title, body, member);
        Post post = PostConverter.toPost(newPostDto);
        postRepository.save(post);
        return post.getId();
    }

    public PostDto readOneByTitle(String postTitle) {
        Optional<Post> post = postRepository.findByTitle(postTitle);
        Post findPost = post.orElseThrow(() -> new GeneralException(ErrorStatus.POST_NOT_FOUND));
        return PostDto.of(findPost);
//        if (findPost.isEmpty()) {
//            log.warn("There is no post.");
//            return null;
//        } else {
//            return PostDto.of(findPost.get());
//        }
    }

    public List<PostDto> readAllByMember(Member member) {
        Optional<List<Post>> postList = postRepository.findByMemberId(member.getId());
        return getPostDtos(postList);
//        if (findPost.isEmpty()) {
//            log.warn("There is no post.");
//            return null;
//        } else {
//            return PostDto.of(findPost.get());
//        }
    }

    public PostDto readOneById(Long id) {
        return PostDto.of(findPostByIdOrThrow(id));
    }

    public List<PostDto> readAll() {
        Optional<List<Post>> postList = Optional.of(postRepository.findAll());
        return getPostDtos(postList);
    }

    private List<PostDto> getPostDtos(Optional<List<Post>> postList) {
        List<Post> findPost = postList.orElseThrow(() -> new GeneralException(ErrorStatus.POST_NOT_FOUND));
        List<PostDto> result = new ArrayList<>();

        for (Post post : findPost) {
            result.add(PostDto.of(post));
        }

        return result;
    }

    public void updatePost(Long id, String newTitle, String newBody) {
        Post findPost = findPostByIdOrThrow(id);
        findPost.update(newTitle, newBody);
        postRepository.save(findPost);
//        if (findPost.isPresent()) {
//            findPost.get().update(newTitle, newBody);
//            postRepository.save(findPost.get());
//        }
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
