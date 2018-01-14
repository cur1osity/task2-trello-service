package com.cur1osity.trelloservice.controller;

import com.cur1osity.trelloservice.domain.TrelloBoardDto;
import com.cur1osity.trelloservice.domain.TrelloCardDto;
import com.cur1osity.trelloservice.service.TrelloService;
import com.cur1osity.trelloservice.client.CreatedTrelloCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloService trelloService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloService.fetchTrelloBoards();
    }

    @GetMapping("/{id}")
    public TrelloBoardDto getTrelloBoard(@PathVariable String id) {
        return trelloService.fetchTrelloBoard(id);
    }

    @PostMapping
    public CreatedTrelloCard createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloService.createdTrelloCardDto(trelloCardDto);
    }
}
