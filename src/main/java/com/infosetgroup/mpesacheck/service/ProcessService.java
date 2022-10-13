package com.infosetgroup.mpesacheck.service;

public interface ProcessService {
    String checkTransaction(String username, String password, String transactionId, String date);
    String checkTransactionv2(String username, String password, String transactionId, String date, String url);
}
