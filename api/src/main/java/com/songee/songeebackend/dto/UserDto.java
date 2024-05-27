package com.songee.songeebackend.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    public String username;
    public String mail;
    public Long id;
//    public String role;
//    public Integer age;
//    public String avatar;
//    public String description;
}
