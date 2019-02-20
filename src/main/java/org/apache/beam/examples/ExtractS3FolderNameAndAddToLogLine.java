package org.apache.beam.examples;

import org.apache.beam.sdk.io.FileIO;
import org.apache.beam.sdk.transforms.DoFn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.Channels;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractS3FolderNameAndAddToLogLine extends DoFn<FileIO.ReadableFile, String> {

    @ProcessElement
    public void processElement(ProcessContext c){

        FileIO.ReadableFile file = c.element();
        String line;
        try (BufferedReader r = new BufferedReader(new InputStreamReader(Channels.newInputStream(file.open())))){
            while ((line = r.readLine())!=null){
                c.output(extractS3FolderFromFilePath(file)+" "+line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String extractS3FolderFromFilePath(FileIO.ReadableFile element) {
        String pattern = "^gs:\\/\\/.*\\/elb-logs\\/(.*)\\/AWSLogs\\/.*\\/elasticloadbalancing\\/.*\\/.*\\/.*\\/.*\\/";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(element.getMetadata().resourceId().toString());
        if(matcher.find()){
           return matcher.group(1);
        } else {
            throw new IllegalStateException("Logs file names doesn't match the expected pattern that is able to extract s3Folder value (e.g. prd-cymes-euw1-walletservice)");
        }
    }
}
