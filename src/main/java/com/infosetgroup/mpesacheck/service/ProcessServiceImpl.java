package com.infosetgroup.mpesacheck.service;

import com.infosetgroup.mpesacheck.util.MpesaUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ProcessServiceImpl implements ProcessService{

    @Override
    public String checkTransaction(String username, String password, String transactionId, String date) {
        String responseContent = null;
        try{
            MpesaUtils.disableSslVerification();
            String host = "https://ipg.m-pesa.vodacom.cd:23003/tqs";
            URL obj = new URL(host);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type", "application/json; utf-8");

            StringBuilder data = new StringBuilder();
            data.append("{");
            data.append("\"input_Username\": \""+username+"\",");
            data.append("\"input_Password\": \""+password+"\",");
            data.append("\"input_TransactionID\": \""+transactionId+"\",");
            data.append("\"input_Date\": \""+date+"\"");
            data.append("}");
            System.out.println(data);

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(data.toString());
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            if (responseCode == 200 || responseCode == 201) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                responseContent = content.toString();
                System.out.println(content.toString());
                return responseContent;
            }else {
                return responseContent;
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return responseContent;
        }
    }

    @Override
    public String checkTransactionv2(String username, String password, String transactionId, String date, String url) {
        String responseContent = null;
        try{
            MpesaUtils.disableSslVerification();
            //String host = "https://ipg.m-pesa.vodacom.cd:23003/tqs";
            String host = url;
            URL obj = new URL(host);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type", "application/json; utf-8");

            StringBuilder data = new StringBuilder();
            data.append("{");
            data.append("\"input_Username\": \""+username+"\",");
            data.append("\"input_Password\": \""+password+"\",");
            data.append("\"input_TransactionID\": \""+transactionId+"\",");
            data.append("\"input_Date\": \""+date+"\"");
            data.append("}");
            System.out.println(data);

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(data.toString());
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            if (responseCode == 200 || responseCode == 201) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                responseContent = content.toString();
                System.out.println(content.toString());
                return responseContent;
            }else {
                return responseContent;
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return responseContent;
        }
    }
}
