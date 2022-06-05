package studyspringboot.restapi.api.practice.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequest {

    private String account;
    private String email;
    private int page;
}
