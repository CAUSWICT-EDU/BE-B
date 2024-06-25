package org.example.boardcrud.service;

import lombok.RequiredArgsConstructor;
import org.example.boardcrud.apiPayload.code.status.ErrorStatus;
import org.example.boardcrud.apiPayload.exception.handler.AuthExceptionHandler;
import org.example.boardcrud.apiPayload.exception.handler.PostExceptionHandler;
import org.example.boardcrud.converter.PostConverter;
import org.example.boardcrud.domain.Member;
import org.example.boardcrud.domain.Post;
import org.example.boardcrud.dto.post.RequestPost;
import org.example.boardcrud.dto.post.ResponsePost;
import org.example.boardcrud.repository.MemberRepository;
import org.example.boardcrud.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Transactional
    public Long createPost(RequestPost.CreateDto createDto) {
        Member member = memberRepository.findByEmail(createDto.getEmail())
                .orElseThrow(() -> new AuthExceptionHandler(ErrorStatus._UNAUTHORIZED));

        Post newPost = PostConverter.createDtoToPost(createDto, member);
        postRepository.save(newPost);

        return newPost.getId();
    }

    @Transactional(readOnly = true)
    public List<ResponsePost.InfoDto> getPosts(Pageable pageable) {
        Page<Post> posts = postRepository.findAll(pageable);

        return PostConverter.postsToInfoDto(posts);
    }

    @Transactional
    public void editPost(RequestPost.EditDto editDto, Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostExceptionHandler(ErrorStatus.POST_NOT_FOUND));
        post.changeTitleAndContent(editDto.getTitle(), editDto.getContent());
        postRepository.save(post);
    }

    @Transactional
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostExceptionHandler(ErrorStatus.POST_NOT_FOUND));

        postRepository.delete(post);
    }

    @Transactional(readOnly = true)
    public ResponsePost.DetailInfoDto getPostDetail(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostExceptionHandler(ErrorStatus.POST_NOT_FOUND));

        return PostConverter.postToDetailInfoDto(post);
    }





}
