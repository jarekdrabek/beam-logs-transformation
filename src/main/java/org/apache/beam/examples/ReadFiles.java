package org.apache.beam.examples;

import org.apache.beam.examples.model.TransferRecord;
import org.apache.beam.sdk.transforms.DoFn;

public class ReadFiles extends DoFn<String, TransferRecord> {

    @ProcessElement
    public void processElement(ProcessContext c){
        String[] log_fields = c.element().split(" ");
//        c.output(TransferRecord.fromSpaceDelimitedString(c.element()));
    }
}
