package class101.foo.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private static Integer PAGE_SIZE = 20;

    @Autowired
    PostRepository postRepository;

    @Autowired
    Producer producer;
    @Autowired
    ObjectMapper objectMapper;
//    @Autowired
//    PostCacheService postCacheService;

    // 1. 글을 작성한다.
    @PostMapping("/post")
    public Post createPost(@RequestBody Post post) throws JsonProcessingException {
        String jsonObject = objectMapper.writeValueAsString(post);
        producer.sendTo(jsonObject);
        return post;
    }
    @GetMapping("/search")
    public List<Post> findPostsByContent(@RequestParam String content) {
        return postRepository.findByContent(content);
    }

    // 2. 글 목록을 페이징하여 반환
//    @GetMapping("/posts")
//    public Page<Post> getPostList(@RequestParam(defaultValue = "1") Integer page) {
//        // 첫 페이지 요청은 캐시로 처리.
//        if (page.equals(1)) {
//            return postCacheService.getFirstPostPage();
//        } else {
//            return postRepository.findAll(
//                    PageRequest.of(page - 1, PAGE_SIZE, Sort.by("id").descending())
//            );
//        }
//
//    }
    // 3. 글 번호로 조회
//    @GetMapping("/post/{id}")
//    public Post getPostById(@PathVariable("id") Long id) {
//        return postRepository.findById(id).get();
//    }
    // 4. 글 내용으로 검색 -> 해당 내용이 포함된 모든 글
//    @GetMapping("/search")
//    public List<Post> getPostByContent(@RequestParam String content) {
//        return postRepository.findByContentContains(content);
//    }


}
