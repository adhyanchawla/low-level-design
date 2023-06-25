package com.example.BookMyShow.services;

import com.example.BookMyShow.payloads.PaymentDto;

public interface PaymentService {
    PaymentDto updatePayment(PaymentDto paymentDto, Integer ticketId);
}
