package com.econovation.rere.domain.dto.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

//  CardBook을 수정할 때 요청 정보를 담는 클래스

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CardBookUpdateRequestDTO {

    @NotEmpty(message = "please write new name")
    private String name;

    @NotEmpty(message = "please write time now")
    private LocalDateTime timenow;

}