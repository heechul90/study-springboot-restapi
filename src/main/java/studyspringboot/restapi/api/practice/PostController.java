package studyspringboot.restapi.api.practice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studyspringboot.restapi.api.practice.request.SearchRequest;

@Slf4j
@RestController
@RequestMapping(value = "/api/post")
public class PostController {

    @PostMapping(value = "/method")
    public SearchRequest postMethod(@RequestBody SearchRequest request) {
        log.info("account = {}, email = {}, page = {}", request.getAccount(), request.getEmail(), request.getPage());
        return request;
    }

}
