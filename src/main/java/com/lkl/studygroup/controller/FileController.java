package com.lkl.studygroup.controller;

import com.lkl.studygroup.common.ApiResponse;
import com.lkl.studygroup.dto.request.UploadFileRequest;
import com.lkl.studygroup.dto.request.UserUpdateRequest;
import com.lkl.studygroup.model.User;
import com.lkl.studygroup.model.UserPrincipal;
import com.lkl.studygroup.service.S3CloudFlareR2Service;
import com.lkl.studygroup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileController {
    @Autowired
    private S3CloudFlareR2Service  s3CloudFlareR2Service;
    @Autowired
    private UserService userService;
    @PostMapping("/generate-presign-url-avatar")
    public ApiResponse<String> generateUploadFile(@RequestBody UploadFileRequest uploadFileRequest, @AuthenticationPrincipal UserPrincipal userPrincipal) {
        String userId = userPrincipal.getUserId().toString();
        String customFileName = userId+"_"+uploadFileRequest.getFileName();
        String url = s3CloudFlareR2Service.generateUploadUrl("Avatar", customFileName);
        String publicAvatarUrl = s3CloudFlareR2Service.buildPublicUrl("Avatar", customFileName);
        UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
        userUpdateRequest.setAvatarUrl(publicAvatarUrl);
        userService.updateUser(userPrincipal.getEmail(),userUpdateRequest);
        return ApiResponse.success(url,"successful", null);
    }
}
