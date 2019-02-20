package org.apache.beam.examples.model;

import java.io.Serializable;
import java.lang.reflect.Field;

public class TransferRecord implements Serializable {

    private String s3Folder;

    private String type;
    private String timestamp;
    private String elb;
    private String client_port;
    private String target_port;

    private String request_processing_time;
    private String target_processing_time;
    private String response_processing_time;
    private String elb_status_code;
    private String target_status_code;

    private String received_bytes;
    private String sent_bytes;
    private String request;
    private String user_agent;
    private String ssl_cipher;

    private String ssl_protocol;
    private String target_group_arn;
    private String trace_id;
    private String domain_name;
    private String chosen_cert_arn;

    private String matched_rule_priority;
    private String request_creation_time;
    private String actions_executed;
    private String redirect_url;
    private String error_reason;

    private TransferRecord() {

    }

    public static TransferRecord fromSpaceDelimitedString(String spaceDelimitedString) throws IllegalAccessException {
        String[] log_fields = spaceDelimitedString.split(" ");

        TransferRecord transferRecord = new TransferRecord();

        Field[] fields = TransferRecord.class.getDeclaredFields();
        for(int i = 0; i< fields.length; i++){
            fields[i].set(transferRecord, log_fields[i]);
        }
        return transferRecord;
//        return new TransferRecord(
//                log_fields[0],
//                log_fields[1],
//                log_fields[2],
//                log_fields[3],
//                log_fields[4],
//                log_fields[5],
//
//                log_fields[6],
//                log_fields[7],
//                log_fields[8],
//                log_fields[9],
//                log_fields[10],
//
//                log_fields[5],
//                log_fields[5],
//                log_fields[5],
//                log_fields[5],
//                log_fields[5],
//
//                log_fields[5],
//                log_fields[5],
//                log_fields[5],
//                log_fields[5],
//                log_fields[5],
//
//                log_fields[5],
//                log_fields[5],
//                log_fields[5],
//                log_fields[5],
//                log_fields[5]
//
//        );
    }

    public String getS3Folder() {
        return s3Folder;
    }

    public String getType() {
        return type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getElb() {
        return elb;
    }

    public String getClient_port() {
        return client_port;
    }

    public String getTarget_port() {
        return target_port;
    }

    public String getRequest_processing_time() {
        return request_processing_time;
    }

    public String getTarget_processing_time() {
        return target_processing_time;
    }

    public String getResponse_processing_time() {
        return response_processing_time;
    }

    public String getElb_status_code() {
        return elb_status_code;
    }

    public String getTarget_status_code() {
        return target_status_code;
    }

    public String getReceived_bytes() {
        return received_bytes;
    }

    public String getSent_bytes() {
        return sent_bytes;
    }

    public String getRequest() {
        return request;
    }

    public String getUser_agent() {
        return user_agent;
    }

    public String getSsl_cipher() {
        return ssl_cipher;
    }

    public String getSsl_protocol() {
        return ssl_protocol;
    }

    public String getTarget_group_arn() {
        return target_group_arn;
    }

    public String getTrace_id() {
        return trace_id;
    }

    public String getDomain_name() {
        return domain_name;
    }

    public String getChosen_cert_arn() {
        return chosen_cert_arn;
    }

    public String getMatched_rule_priority() {
        return matched_rule_priority;
    }

    public String getRequest_creation_time() {
        return request_creation_time;
    }

    public String getActions_executed() {
        return actions_executed;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public String getError_reason() {
        return error_reason;
    }

    @Override
    public String toString() {
        return "TransferRecord{" +
                "s3Folder='" + s3Folder + '\'' +
                ", target_status_code='" + target_status_code + '\'' +
                ", request='" + request + '\'' +
                '}';
    }

    public static void main(String[] args) throws IllegalAccessException {
        TransferRecord transferRecord = TransferRecord.fromSpaceDelimitedString("prd-cymes-euw1-walletservice https 2019-02-01T10:35:34.374285Z app/awseb-AWSEB-14YOUYUUAWYXF/7a060ffe0a97c917 192.168.32.250:34098 192.168.32.250:80 0.001 0.002 0.000 200 200 227 1064 \"GET https://euw1-walletservice.atm-osp.com:443/health-check HTTP/1.1\" \"Java/1.8.0_191\" ECDHE-RSA-AES128-GCM-SHA256 TLSv1.2 arn:aws:elasticloadbalancing:eu-west-1:400144580646:targetgroup/awseb-AWSEB-1QUUOS8918BW3/335cfa98f0174dc0 \"Root=1-5c5420f6-46aa80c5a01c96bafda51905\" \"euw1-walletservice.atm-osp.com\" \"arn:aws:acm:eu-west-1:400144580646:certificate/d489e7aa-defe-436b-a6e0-28f058bd7000\" 0 2019-02-01T10:35:34.370000Z \"forward\" \"-\" \"-\"");

        System.out.println(transferRecord);
    }
}
