package com.lkl.studygroup.dto.request;

import lombok.Data;

@Data
public class UploadFileRequest {
    private String fileName;

    public UploadFileRequest(String fileName) {
        this.fileName = fileName;
    }
}
