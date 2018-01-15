package com.cur1osity.trelloservice.service;

import com.cur1osity.trelloservice.config.AdminConfig;
import com.cur1osity.trelloservice.domain.Mail;
import com.cur1osity.trelloservice.domain.TrelloBoardDto;
import com.cur1osity.trelloservice.domain.TrelloCardDto;
import com.cur1osity.trelloservice.client.CreatedTrelloCard;
import com.cur1osity.trelloservice.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.util.Optional.ofNullable;

@Service
public class TrelloService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private TrelloClient trelloClient;

    @Autowired
    private SimpleEmailService emailService;

    private static final String SUBJECT = "Task: New Trello card";

    public List<TrelloBoardDto> fetchTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    public TrelloBoardDto fetchTrelloBoard(String id) {
        return trelloClient.getTrelloBoard(id);
    }

    public CreatedTrelloCard createdTrelloCardDto(final TrelloCardDto trelloCardDto){
        CreatedTrelloCard newCard = trelloClient.createNewCard(trelloCardDto);

        ofNullable(newCard).ifPresent(
                card -> emailService.send(
                        new Mail(
                                adminConfig.getAdminMail(),
                                SUBJECT,
                                "New card: "  + card.getName() + " has been created on your Trello account")));

        return newCard;
    }
}
