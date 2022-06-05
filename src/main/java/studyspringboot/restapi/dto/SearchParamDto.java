package studyspringboot.restapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchParamDto {

    private String account;
    private String email;
    private int page;
}
