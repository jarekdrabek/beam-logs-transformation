package org.apache.beam.examples.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    public static TransferRecord fromSpaceDelimitedString(String spaceDelimitedString) throws IllegalAccessException {
        List<String> log_fields = tokenizeStringButIgnoreDelimitersWithinQuotes(spaceDelimitedString);

        TransferRecord transferRecord = new TransferRecord();

        Field[] fields = TransferRecord.class.getDeclaredFields();
        for(int i = 0; i< fields.length; i++){
            fields[i].set(transferRecord, log_fields.get(i));
        }
        return transferRecord;
    }

    private static List<String> tokenizeStringButIgnoreDelimitersWithinQuotes(String spaceDelimitedString) {
        String regex = "\"([^\"]*)\"|(\\S+)";
        List<String> list = new ArrayList<>();
        Matcher m = Pattern.compile(regex).matcher(spaceDelimitedString);

        while(m.find()){
            if(m.group(1)!=null){
                list.add(m.group(1));
            } else {
                list.add(m.group(2));
            }
        }
        return list;
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
                ", type='" + type + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", elb='" + elb + '\'' +
                ", client_port='" + client_port + '\'' +
                ", target_port='" + target_port + '\'' +
                ", request_processing_time='" + request_processing_time + '\'' +
                ", target_processing_time='" + target_processing_time + '\'' +
                ", response_processing_time='" + response_processing_time + '\'' +
                ", elb_status_code='" + elb_status_code + '\'' +
                ", target_status_code='" + target_status_code + '\'' +
                ", received_bytes='" + received_bytes + '\'' +
                ", sent_bytes='" + sent_bytes + '\'' +
                ", request='" + request + '\'' +
                ", user_agent='" + user_agent + '\'' +
                ", ssl_cipher='" + ssl_cipher + '\'' +
                ", ssl_protocol='" + ssl_protocol + '\'' +
                ", target_group_arn='" + target_group_arn + '\'' +
                ", trace_id='" + trace_id + '\'' +
                ", domain_name='" + domain_name + '\'' +
                ", chosen_cert_arn='" + chosen_cert_arn + '\'' +
                ", matched_rule_priority='" + matched_rule_priority + '\'' +
                ", request_creation_time='" + request_creation_time + '\'' +
                ", actions_executed='" + actions_executed + '\'' +
                ", redirect_url='" + redirect_url + '\'' +
                ", error_reason='" + error_reason + '\'' +
                '}';
    }
}
