package com.panikbutonu.service;

import org.springframework.stereotype.Service;

@Service
public class SmsService {
    
    public void konumGonder(String telefonNumarasi) {
        // Burada gerçek bir SMS API'si kullanılmalıdır
        // Örnek olarak Twilio veya benzeri bir servis kullanılabilir
        String konum = konumAl();
        // SMS gönderme işlemi burada gerçekleştirilir
        System.out.println("Konum " + telefonNumarasi + " numarasına gönderildi: " + konum);
    }

    private String konumAl() {
        // Burada gerçek konum alma işlemi yapılmalıdır
        // Örnek olarak sabit bir konum döndürüyoruz
        return "41.015137,28.979530"; // İstanbul koordinatları
    }
} 