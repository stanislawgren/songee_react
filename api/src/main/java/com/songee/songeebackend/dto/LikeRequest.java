package com.songee.songeebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikeRequest {
    public Integer user_id;
    public Integer liked_id;
    public Integer value;
}
