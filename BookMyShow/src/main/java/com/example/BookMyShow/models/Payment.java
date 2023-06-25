package com.example.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment extends BaseModel {
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private String paymentRefId;
    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    private Ticket ticket;
}
