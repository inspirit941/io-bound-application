//package class101.foo.io;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PostCacheService {
//    @Autowired
//    PostRepository postRepository;
//
//    private Page<Post> firstPostPage;
//
//    @Scheduled(cron = "* * * * * *") // 1초에 한 번씩 작업을 수행한다는 의미의 cron식.
//    public void updateFirstPostPage() {
//        firstPostPage = postRepository.findAll(
//                PageRequest.of(0, 20, Sort.by("id").descending())
//        );
//    }
//
//    public Page<Post> getFirstPostPage() {
//        return this.firstPostPage;
//    }
//}
