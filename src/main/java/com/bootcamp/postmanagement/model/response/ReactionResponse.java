package com.bootcamp.postmanagement.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.bootcamp.postmanagement.model.enumeration.ReactionType;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class ReactionResponse {
    private UserResponse user;

    @ApiModelProperty(example = "LIKE")
    private ReactionType reactionType;
}
