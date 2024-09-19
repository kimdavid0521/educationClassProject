package com.example.EducationClassProject.dto.chatDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ChatRequestDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SendChatMessageDTO {
        private String content;
        private Long chatroomId;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MakeChatroomRequestDTO {
        private String roomName;
        private String owner;
        private boolean isSecret;
        private String password;
    }
}
