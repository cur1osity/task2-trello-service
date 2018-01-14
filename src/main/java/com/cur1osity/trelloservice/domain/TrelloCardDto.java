package com.cur1osity.trelloservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class TrelloCardDto {

    @NotBlank(message = "Name can't be blank")
    private String name;
    @NotBlank(message = "Description can't be blank")
    private String description;
    private String pos;
    @NotBlank(message = "Please select Trello List")
    private String listId;

}