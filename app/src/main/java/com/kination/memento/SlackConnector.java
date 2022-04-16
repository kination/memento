package com.kination.memento;


import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.response.conversations.ConversationsHistoryResponse;
import com.slack.api.methods.response.conversations.ConversationsListResponse;
import com.slack.api.model.Conversation;
import com.slack.api.model.Message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class SlackConnector {
    private String _token;
    SlackConnector(String token) {
        this._token = token;
    }

    List<String> getList() throws IOException, SlackApiException {
        return getConversationList();
    }

    String getList(String filter) {
        return "";
    }

    private List<String> getConversationList() throws IOException, SlackApiException {
        MethodsClient client = Slack.getInstance().methods(this._token);
        ConversationsListResponse result = client.conversationsList(r -> r);
        List<String> conversations = new ArrayList<>();

        for (Conversation channel : result.getChannels()) {
            ConversationsHistoryResponse chp = client.conversationsHistory(r -> r.channel(channel.getId()));
            List<Message> messages = Optional.ofNullable(chp.getMessages()).orElse(Collections.emptyList());
            conversations.addAll(
                    messages.stream().map(Message::getText).collect(Collectors.toList())
            );

        }
        return conversations;
    }
}
