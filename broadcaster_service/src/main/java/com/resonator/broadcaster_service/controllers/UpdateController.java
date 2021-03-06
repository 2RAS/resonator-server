package com.resonator.broadcaster_service.controllers;

import com.resonator.broadcaster_service.dao.ChatDAO;
import com.resonator.broadcaster_service.entity.ChatMessage;
import com.resonator.broadcaster_service.entity.ChatUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;

@RestController
@Transactional
@RequestMapping("/updateChat")
public class UpdateController {
    @Autowired
    private ChatDAO chatDAO;

    public String getUserId(Principal principal) {
        KeycloakAuthenticationToken  token = (KeycloakAuthenticationToken) principal;
        KeycloakPrincipal pr = (KeycloakPrincipal) token.getPrincipal();
        KeycloakSecurityContext session = pr.getKeycloakSecurityContext();
        AccessToken at = session.getToken();
        String id = at.getOtherClaims().get("user_id").toString();

        return id;
    }

    /*@RequestMapping(value = "/test", produces = "application/json")
    public int home(int a, String s) {
        System.out.println(s);
        return a;
    }*/

    @GetMapping(value = "/getAllUnreadMessages", produces = "application/json")
    List<ChatMessage> getAllUnreadMessages(Principal principal) {
        String userId = getUserId(principal);

        return chatDAO.getAllUnreadMessages(userId);
    }

    @GetMapping(value = "/getAllUnreadMessagesIds", produces = "application/json")
    List getAllUnreadMessagesIds(Principal principal) {
        String userId = getUserId(principal);

        return chatDAO.getAllUnreadMessagesIds(userId);
    }

    @GetMapping(value = "/getAllUserUnreadMessages", produces = "application/json")
    List<ChatMessage> getAllUserUnreadMessages(Principal principal, String chatId) {
        String userId = getUserId(principal);

        return chatDAO.getAllUserUnreadMessages(userId, chatId);
    }

    @GetMapping(value = "/getAllUserConversations", produces = "application/json")
    List<Object> getAllUserConversations(Principal principal) {
        String userId = getUserId(principal);

        return chatDAO.getAllUserConversations(userId);
    }

    @GetMapping(value = "/getAllUserConversationMessages", produces = "application/json")
    List<ChatMessage> getAllUserConversationMessages(Principal principal, String chatId) {
        String userId = getUserId(principal);

        return chatDAO.getAllUserConversationMessages(userId, chatId);
    }

    @GetMapping(value = "/checkParticipate", produces = "application/json")
    Boolean checkParticipate(Principal principal, String dialogId, String chatId) {
        String userId = getUserId(principal);

        return chatDAO.checkParticipate(userId, dialogId, chatId);
    }

    @GetMapping(value = "/hasNewChats", produces = "application/json")
    Boolean hasNewChats(Principal principal) {
        String userId = getUserId(principal);

        return chatDAO.hasNewChats(userId);
    }

    @GetMapping(value = "/getChatUsers", produces = "application/json")
    List<ChatUser> getChatUsers(String chatId) {
        return chatDAO.getChatUsers(chatId);
    }
}
