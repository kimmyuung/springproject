package org.springpratice.controller.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springpratice.controller.web.dto.PostsResponseDto;
import org.springpratice.controller.web.dto.PostsSaveRequestDto;
import org.springpratice.controller.web.dto.PostsUpdateRequestDto;
import org.springpratice.service.posts.PostsService;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/vi/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

}

