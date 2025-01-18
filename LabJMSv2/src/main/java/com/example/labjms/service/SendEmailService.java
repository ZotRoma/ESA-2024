package com.example.labjms.service;

import com.example.labjms.dto.LetterDto;

public interface SendEmailService {
    void sendEmail(LetterDto letterDto);
}
