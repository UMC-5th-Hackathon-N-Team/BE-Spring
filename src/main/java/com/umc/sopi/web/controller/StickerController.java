package com.umc.sopi.web.controller;

import com.umc.sopi.Service.StickerImageService.StickerImageService;
import com.umc.sopi.Service.UserStickerService.UserStickerService;
import com.umc.sopi.apiPayload.ApiResponse;
import com.umc.sopi.converter.StickerConverter;
import com.umc.sopi.domain.StickerImage;
import com.umc.sopi.web.dto.StickerResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sticker")
public class StickerController {

    private final StickerImageService stickerImageService;
    private final UserStickerService userStickerService;

    @PostMapping("/draw/{stickerId}")
    public ApiResponse<StickerResponseDTO.stickerResultDTO> stickerDraw(@PathVariable(name = "stickerId") Long stickerId,
                                                                        @RequestParam(name = "userId") Long userId) {
        StickerImage image = stickerImageService.addSticker(stickerId, userId);
        return ApiResponse.onSuccess(StickerConverter.toStickerDTO(image));
    }

    @GetMapping("/board/{userId}")
    public ApiResponse<StickerResponseDTO.stickerListResultDTO> stickerList(@PathVariable(name = "userId") Long userId) {
        List<StickerImage> list = userStickerService.findSticker(userId);
        return ApiResponse.onSuccess(StickerConverter.stickerListResultDTO(list));
    }
}