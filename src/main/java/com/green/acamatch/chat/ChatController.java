package com.green.acamatch.chat;

import com.green.acamatch.chat.model.*;
import com.green.acamatch.config.model.ResultResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("chat")
@Tag(name = "채팅")
public class ChatController {
    private final ChatService chatService;
    @PostMapping
    @Operation(summary = "메세지 전송(로그인 필수)", description = "sender-type : {0: user-> aca, 1: aca -> user}")
    public ResultResponse<Integer> sendMessage(ChatSendReq req) {
        chatService.sendMessage(req);
        return ResultResponse.<Integer>builder().resultData(1).build();
    }

    @GetMapping("log")
    @Operation(summary = "메세지 내역 조회(로그인 필수)")
    public ResultResponse<List<ChatLogRes>> getQnas(@ParameterObject @ModelAttribute ChatReq req) {
        return ResultResponse.<List<ChatLogRes>>builder().resultData(chatService.getQna(req)).build();
    }

    @GetMapping
    @Operation(summary = "채팅방 목록(로그인 필수)", description = "user-id 또는 aca-id 중 하나만 보내주세요")
    public ResultResponse<List<ChatUserListRes>> getUserList(@ParameterObject @ModelAttribute ChatReq req) {
        return ResultResponse.<List<ChatUserListRes>>builder().resultData(chatService.getUserList(req)).build();
    }
}
