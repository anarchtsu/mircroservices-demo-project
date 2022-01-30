package ru.gontarenko.fraud.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(indexes = @Index(name = "fraud_check_history_email_idx", columnList = "email", unique = true))
@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FraudCheckHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    String email;
    @NotNull
    boolean fraudster;
    @NotNull
    LocalDateTime createdAt;

    public FraudCheckHistory(boolean fraudster, String email) {
        setFraudster(fraudster);
        setEmail(email);
        setCreatedAt(LocalDateTime.now());
    }
}
