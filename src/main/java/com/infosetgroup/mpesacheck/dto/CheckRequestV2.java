package com.infosetgroup.mpesacheck.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CheckRequestV2 {
    private String transactionId;
    private String transactionDate;
    private String username;
    private String password;
    private String url;
}
