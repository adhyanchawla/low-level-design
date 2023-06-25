package com.example.BookMyShow.payloads;

import com.example.BookMyShow.models.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private PaymentStatus paymentStatus;
    private String paymentRefId;
    private TicketDto ticket;
}
