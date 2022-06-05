package studyspringboot.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import studyspringboot.restapi.dto.SearchParamDto;

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
    public SearchParamDto getMultiParam(SearchParamDto dto) {
        log.info("accout = {}, email = {}, page = {}", dto.getAccount(), dto.getEmail(), dto.getPage());
        return dto;
    }
}
