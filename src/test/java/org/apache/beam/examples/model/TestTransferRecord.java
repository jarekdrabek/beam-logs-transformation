package org.apache.beam.examples.model;

import org.junit.Assert;
import org.junit.Test;

public class TestTransferRecord {

    @Test
    public void test1() throws IllegalAccessException {
        TransferRecord transferRecord = TransferRecord.fromSpaceDelimitedString("prd-abcd-euw1-abcdserw https 2019-02-01T10:35:34.374285Z app/awseb-AWSEB-14YOUYUUAWYXF/7a060ffe0a97c917 192.168.32.250:34098 192.168.32.250:80 0.001 0.002 0.000 200 200 227 1064 \"GET https://euw1-walletservice.atm-osp.com:443/health-check HTTP/1.1\" \"Java/1.8.0_191\" ECDHE-RSA-AES128-GCM-SHA256 TLSv1.2 arn:aws:elasticloadbalancing:eu-west-1:400144580646:targetgroup/awseb-AWSEB-1QUUOS8918BW3/335cfa98f0174dc0 \"Root=1-5c5420f6-46aa80c5a01c96bafda51905\" \"euw1-wallesdsatservice.atm-osp.com\" \"arn:aws:acm:eu-west-1:400144580646:certificate/d489e7aa-defe-436b-a6e0-28f058bd7000\" 0 2019-02-01T10:35:34.370000Z \"forward\" \"-\" \"-\"");
        System.out.println("prd-cymes-euw1-walletservice https 2019-02-01T10:35:34.374285Z app/awseb-AWSEB-14YOUYUUAWYXF/7a060ffe0a97c917 192.168.32.250:34098 192.168.32.250:80 0.001 0.002 0.000 200 200 227 1064 \"GET https://euw1-walletservice.atm-osp.com:443/health-check HTTP/1.1\" \"Java/1.8.0_191\" ECDHE-RSA-AES128-GCM-SHA256 TLSv1.2 arn:aws:elasticloadbalancing:eu-west-1:400144580646:targetgroup/awseb-AWSEB-1QUUOS8918BW3/335cfa98f0174dc0 \"Root=1-5c5420f6-46aa80c5a01c96bafda51905\" \"euw1-walletservice.atm-osp.com\" \"arn:aws:acm:eu-west-1:400144580646:certificate/d489e7aa-defe-436b-a6e0-28f058bd7000\" 0 2019-02-01T10:35:34.370000Z \"forward\" \"-\" \"-\"");
        Assert.assertEquals(
                "TransferRecord{s3Folder='prd-abcd-euw1-abcdserw', type='https', timestamp='2019-02-01T10:35:34.374285Z', elb='app/awseb-AWSEB-14YOUYUUAWYXF/7a060ffe0a97c917', client_port='192.168.32.250:34098', target_port='192.168.32.250:80', request_processing_time='0.001', target_processing_time='0.002', response_processing_time='0.000', elb_status_code='200', target_status_code='200', received_bytes='227', sent_bytes='1064', request='GET https://euw1-walletservice.atm-osp.com:443/health-check HTTP/1.1', user_agent='Java/1.8.0_191', ssl_cipher='ECDHE-RSA-AES128-GCM-SHA256', ssl_protocol='TLSv1.2', target_group_arn='arn:aws:elasticloadbalancing:eu-west-1:400144580646:targetgroup/awseb-AWSEB-1QUUOS8918BW3/335cfa98f0174dc0', trace_id='Root=1-5c5420f6-46aa80c5a01c96bafda51905', domain_name='euw1-wallesdsatservice.atm-osp.com', chosen_cert_arn='arn:aws:acm:eu-west-1:400144580646:certificate/d489e7aa-defe-436b-a6e0-28f058bd7000', matched_rule_priority='0', request_creation_time='2019-02-01T10:35:34.370000Z', actions_executed='forward', redirect_url='-', error_reason='-'}",
                transferRecord.toString()
        );
    }

}
