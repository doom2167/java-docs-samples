/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.language.automl.entityextraction.samples;

// [START automl_natural_language_entity_delete_model]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.ModelName;
import com.google.cloud.automl.v1beta1.OperationMetadata;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

class DeleteModel {

  // Delete a model
  static void deleteModel(String projectId, String computeRegion, String modelId)
      throws IOException, InterruptedException, ExecutionException {
    // String projectId = "YOUR_PROJECT_ID";
    // String computeRegion = "us-central1";
    // String modelId = "YOUR_MODEL_ID";

    // Instantiates a client
    try (AutoMlClient client = AutoMlClient.create()) {

      // Get the full path of the model.
      ModelName modelName = ModelName.of(projectId, computeRegion, modelId);

      // Delete a model.
      OperationFuture<Empty, OperationMetadata> response = client.deleteModelAsync(modelName);

      System.out.println("Model deletion started...");
      System.out.println(String.format("Model deleted. %s", response.getName()));
    }
  }
}
// [END automl_natural_language_entity_delete_model]