/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.beam.examples;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.FileIO;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.options.Validation.Required;
import org.apache.beam.sdk.transforms.ParDo;


public class LogsTransformer {


    public interface LogsLoadOptions extends PipelineOptions {

        @Description("Path of the file to read from")
        @Default.String("gs://apache-beam-samples/*/*")
        String getInputFile();

        void setInputFile(String value);

        @Description("Path of the file to write to")
        @Required
        String getOutput();

        void setOutput(String value);
    }

    static void runLogsLoad(LogsLoadOptions options) {
        Pipeline p = Pipeline.create(options);

        p.apply(FileIO.match().filepattern(options.getInputFile()))
                .apply(FileIO.readMatches())
                .apply("TransformToTransferRecord", ParDo.of(new ExtractS3FolderNameAndAddToLogLine()))
                .apply("WriteToOutput", TextIO.write().to(options.getOutput()));

        p.run();
    }

    public static void main(String[] args) {
        LogsLoadOptions options =
                PipelineOptionsFactory.fromArgs(args).withValidation().as(LogsLoadOptions.class);

        runLogsLoad(options);
    }
}
