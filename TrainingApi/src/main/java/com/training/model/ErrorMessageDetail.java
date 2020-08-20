package com.training.model;

import lombok.Data;

@Data
public class ErrorMessageDetail {
    private int statusCode;
    private String message;
    private String fileName;
    private String meThodName;
    private int line;

    public ErrorMessageDetail(int statusCode, String message, Exception ex) {
        if(ex.getStackTrace().length > 0 && ex.getStackTrace()[0] != null) {
            this.statusCode = statusCode;
            this.message = message;
            this.fileName = ex.getStackTrace()[0].getFileName();
            this.meThodName = ex.getStackTrace()[0].getMethodName();
            this.line = ex.getStackTrace()[0].getLineNumber();
        }
    }
}