package com.example.BookMyShow.controllers;

import com.example.BookMyShow.payloads.PaymentDto;
import com.example.BookMyShow.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/ticket/{ticketId}/update")
    public ResponseEntity<PaymentDto> updatePayment(@RequestBody PaymentDto paymentDto, @PathVariable Integer ticketId) {
        PaymentDto paymentDto1 = this.paymentService.updatePayment(paymentDto, ticketId);
        return new ResponseEntity<>(paymentDto1, HttpStatus.CREATED);
    }
}
