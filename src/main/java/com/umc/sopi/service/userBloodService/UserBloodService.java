package com.umc.sopi.service.userBloodService;

import com.umc.sopi.domain.UserBlood;
import com.umc.sopi.web.dto.UserBloodRequest;
import com.umc.sopi.web.dto.UserBloodResponse;

import java.util.List;

public interface UserBloodService {
    UserBlood registerBlood(UserBloodRequest.RegisterDTO registerDTO);
    List<UserBlood> userBloodList(Long userId);
}
