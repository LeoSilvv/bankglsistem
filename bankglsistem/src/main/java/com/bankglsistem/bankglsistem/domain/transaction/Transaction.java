package com.bankglsistem.bankglsistem.domain.transaction;

import com.bankglsistem.bankglsistem.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="transactions")
@Table(name="transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    @ManyToMany
    @JoinColumn(name="sender_id")
    private User sender;
    @ManyToMany
    @JoinColumn(name="receiver_id")
    private User receiver;
    private LocalDateTime timesTamp;
}
