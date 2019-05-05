package com.metao.persoinfo;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RunWith(JUnit4.class)
public class GoogleCloudTest {


  @Test
  public void test() throws IOException, ExecutionException, InterruptedException {

    // Use a service account
    InputStream serviceAccount = new FileInputStream("/Users/mal/back/persoinfo_back/one/src/main/resources/persoinfo-239623-d9fba2d27925.json");
    GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
    FirebaseOptions options = new FirebaseOptions.Builder()
      .setCredentials(credentials)
      .build();
    FirebaseApp.initializeApp(options);

    Firestore db = FirestoreClient.getFirestore();

    DocumentReference docRef = db.collection("persoinfo").document("filter");
// Add document data  with id "alovelace" using a hashmap
    Map<String, Object> data = new HashMap<>();
    data.put("id", "Ada");
    data.put("title", "Lovelace");
//asynchronously write data
    ApiFuture<WriteResult> result = docRef.set(data);
// ...
// result.get() blocks on response
    System.out.println("Update time : " + result.get().getUpdateTime());
    Assert.assertEquals(1, 1);
  }
}
