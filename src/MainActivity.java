package com.example.pc43.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private String API_KEY = "_nn1V5xxRxq8MHOKUBN4NHzr18_4WsUq";
    private String DATABASE = "whitewhale";
    private String COLLECTION = "test";
    private MongoLabClient mongoLabClient;
    JSONObject jsonObject,jsonObject2,jsonObject3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check Databases and Collections
        mongoLabClient = new MongoLabClient(API_KEY);
        mongoLabClient.getDatabaseName();

        mongoLabClient = new MongoLabClient(API_KEY);
        mongoLabClient.getCollectionName(DATABASE);

        mongoLabClient = new MongoLabClient(API_KEY,DATABASE);
        mongoLabClient.getCollectionName();

        //Insert Example
        try {
            jsonObject = new JSONObject();
            jsonObject.put("one", "data01");
            jsonObject.put("two", "jsonObject");
            jsonObject2 = new JSONObject();
            jsonObject2.put("three-one", 99);
            jsonObject2.put("three-two", "BasicDBObject");
            jsonObject.put("three", jsonObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mongoLabClient = new MongoLabClient(API_KEY,DATABASE,COLLECTION);
        mongoLabClient.insert(jsonObject);

        try {
            jsonObject = new JSONObject();
            jsonObject.put("one", "data02");
            jsonObject.put("two", "jsonObject");
            jsonObject.put("three", 33);
            jsonObject2 = new JSONObject();
            jsonObject2.put("one", "data03");
            jsonObject2.put("two", "jsonObject");
            jsonObject2.put("three", 33);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray= new JSONArray();
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject2);
        mongoLabClient = new MongoLabClient(API_KEY,DATABASE,COLLECTION);
        mongoLabClient.insert(jsonArray);

        //Count Example
        try {
            jsonObject = new JSONObject();
            jsonObject.put("three", 33);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mongoLabClient = new MongoLabClient(API_KEY,DATABASE,COLLECTION);
        mongoLabClient.count();

        mongoLabClient = new MongoLabClient(API_KEY,DATABASE,COLLECTION);
        mongoLabClient.count(jsonObject);

        mongoLabClient = new MongoLabClient(API_KEY,DATABASE,COLLECTION);
        mongoLabClient.count(jsonObject.toString());

        //Find Example
        mongoLabClient = new MongoLabClient(API_KEY,DATABASE,COLLECTION);
        mongoLabClient.find();

        mongoLabClient = new MongoLabClient(API_KEY,DATABASE,COLLECTION);
        mongoLabClient.find(jsonObject);

        mongoLabClient = new MongoLabClient(API_KEY,DATABASE,COLLECTION);
        mongoLabClient.find(jsonObject.toString());

        mongoLabClient = new MongoLabClient(API_KEY,DATABASE,COLLECTION);
        mongoLabClient.findOne(jsonObject);

        mongoLabClient = new MongoLabClient(API_KEY,DATABASE,COLLECTION);
        mongoLabClient.findOne(jsonObject.toString());

        //Update Example
        try {
            jsonObject = new JSONObject();
            jsonObject.put("name", "data01");
            jsonObject2 = new JSONObject();
            jsonObject2.put("three", 1111);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mongoLabClient = new MongoLabClient(API_KEY,DATABASE,COLLECTION);
        mongoLabClient.update(jsonObject,jsonObject2);

        try {
            jsonObject = new JSONObject();
            jsonObject.put("name", "data02");
            jsonObject2 = new JSONObject();
            jsonObject2.put("three", 100);
            jsonObject3 = new JSONObject();
            jsonObject3.put("set", jsonObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mongoLabClient = new MongoLabClient(API_KEY,DATABASE,COLLECTION);
        mongoLabClient.update(jsonObject.toString(),jsonObject3);

        try {
            jsonObject = new JSONObject();
            jsonObject.put("name", "data03");
            jsonObject2 = new JSONObject();
            jsonObject2.put("three", 100);
            jsonObject3 = new JSONObject();
            jsonObject3.put("inc", jsonObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mongoLabClient = new MongoLabClient(API_KEY,DATABASE,COLLECTION);
        mongoLabClient.update(jsonObject,jsonObject3.toString());

        //Delete Example, Deletion is only possible with id.
        mongoLabClient = new MongoLabClient(API_KEY,DATABASE,COLLECTION);
        mongoLabClient.delete("5938e82bc2ef166bf5111825");
    }
}














