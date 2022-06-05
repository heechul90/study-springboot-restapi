package studyspringboot.restapi.api.practice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import studyspringboot.restapi.api.practice.request.SearchRequest;

@Slf4j
@RestController
@RequestMapping(value = "/api/get")
public class GetController {

    @GetMapping(value = "/method")
    public String getMethod() {
        return "Hi Get Method";
    }

    @GetMapping(value = "/param")
    public String getParam(@RequestParam("id") Long id, @RequestParam("password") String password) {
        log.info("id = {}, password = {}", id, password);
        return "id = " + id + ", password = " + password;
    }

    @GetMapping(value = "/multi-param")
    public SearchRequest getMultiParam(SearchRequest request) {
        log.info("accout = {}, email = {}, page = {}", request.getAccount(), request.getEmail(), request.getPage());
        return request;
    }
}
