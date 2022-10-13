package com.infosetgroup.mpesacheck.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CheckRequest {
    private String transactionId;
    private String transactionDate;
    private String username;
    private String password;
}
