package com.songee.songeebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PairResponse {
    public Long id;
    public String username;
    public String firstName;
    public String avatar;
}
