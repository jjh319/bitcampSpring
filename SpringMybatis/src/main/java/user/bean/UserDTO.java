package user.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class UserDTO {

    private String name;
    private String id;
    private String pwd;

    public String toString(){
        return name + " " + id + " " + pwd;
    }
}
