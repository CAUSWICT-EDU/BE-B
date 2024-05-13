package cau.ict.btrack.dto;
import cau.ict.btrack.domain.User;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {
    private String name;
    private int height;
    private int weight;
    private int gender;
    private int age;

    public User toEntity() {
        return new User(name, height, weight, gender, age);
    }
}
