package com.songee.songeebackend.dto;
import com.songee.songeebackend.entity.Role;
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
    public Integer age;
    public String firstName;
    public String lastName;
    public Character gender;
    public String favouriteSongTitle;
    public String favouriteArtist;
    public String description;
    public String favouriteSongArtist;
    public int spotify;
    public int x2fa;
    public int phone;
    public String location;
    public String avatar;
    public int status;
    public Enum<Role> role;
}
