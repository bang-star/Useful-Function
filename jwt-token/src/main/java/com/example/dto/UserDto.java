package com.example.dto;

import com.example.domain.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotNull @Size(min = 3, max = 50) private String username;
    @NotNull @Size(min = 3, max = 50) private String nickname;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull @Size(min = 3, max = 50) private String password;

    private Set<AuthorityDto> authorityDtoSet;

    public static UserDto from(User entity){
        if(entity == null)
            return null;

        return UserDto.builder()
                .username(entity.getUsername())
                .nickname(entity.getNickname())
                .authorityDtoSet(entity.getAuthorities().stream()
                        .map(authority -> AuthorityDto.builder().authorityName(authority.getAuthorityName()).build())
                        .collect(Collectors.toSet()))
                .build();
    }

}
