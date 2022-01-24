package ru.gontarenko.fraud.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FraudCheckHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    Integer customerId;
    @NotNull
    boolean fraudster;
    @NotNull
    LocalDateTime createdAt;
}
