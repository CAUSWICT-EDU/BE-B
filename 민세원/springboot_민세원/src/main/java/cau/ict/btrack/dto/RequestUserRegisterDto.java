package cau.ict.btrack.dto;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserRegisterDto {
    private String name;
    private int height;
    private int weight;
    private int gender;
    private int age;
}
