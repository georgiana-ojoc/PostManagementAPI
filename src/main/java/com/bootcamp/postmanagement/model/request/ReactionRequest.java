package com.bootcamp.postmanagement.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.bootcamp.postmanagement.model.enumeration.ReactionType;

@Getter
@Setter
@ToString
public class ReactionRequest {
    @ApiModelProperty(allowableValues = "LIKE, DISLIKE, LOVE, LAUGH, WOW, SAD, ANGRY")
    private ReactionType reactionType;
}
