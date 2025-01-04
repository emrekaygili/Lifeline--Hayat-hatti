package com.panikbutonu.controller;

import com.panikbutonu.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PanikController {

    @Autowired
    private SmsService smsService;

    @GetMapping("/")
    public String anaSayfa() {
        return "index"; // index.html'e yönlendirir
    }

    @PostMapping("/panik")
    @ResponseBody
    public String panikButonu(@RequestParam String telefonNumarasi) {
        try {
            smsService.konumGonder(telefonNumarasi);
            return "Konum başarıyla gönderildi!";
        } catch (Exception e) {
            return "Hata oluştu: " + e.getMessage();
        }
    }
} 