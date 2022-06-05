package studyspringboot.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studyspringboot.restapi.dto.SearchParamDto;

@Slf4j
@RestController
@RequestMapping(value = "/api/post")
public class PostController {

    @PostMapping(value = "/method")
    public SearchParamDto postMethod(@RequestBody SearchParamDto dto) {
        log.info("account = {}, email = {}, page = {}", dto.getAccount(), dto.getEmail(), dto.getPage());
        return dto;
    }

}
