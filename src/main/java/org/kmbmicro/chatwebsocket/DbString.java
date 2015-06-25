/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kmbmicro.chatwebsocket;

/**
 *
 * @author sandiwibowo
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import java.sql.Timestamp;

public class DbString {
    static AWSCredentials credentials;
    static AmazonDynamoDBClient dynamoDBAWS;
    static DynamoDB dynamoDB;

    static String tableName = "MessagesChat";
    private static long dateNow(){
		java.util.Date date= new java.util.Date();
		return new Timestamp(date.getTime()).getTime();
    }
    public static void  init() {
         try {
             credentials = new ProfileCredentialsProvider("default").getCredentials();
         } catch (Exception e) {
             throw new AmazonClientException(
                     "Cannot load the credentials from the credential profiles file. " +
                     "Please make sure that your credentials file is at the correct " +
                     "location (/Users/sandiwibowo/.aws/credentials), and is in valid format.",
                     e);
         }
     	AmazonDynamoDBClient dynamoDBAWS = new AmazonDynamoDBClient(credentials);
        Region usWest2 = Region.getRegion(Regions.US_WEST_2);
     	dynamoDBAWS.setRegion(usWest2);
     	dynamoDB = new DynamoDB(dynamoDBAWS);
    }

    public static void createItems(ChatData chatData) {

        Table table = dynamoDB.getTable(tableName);
        System.out.println(table.getTableName());
        try {

            Item item = new Item()
                .withPrimaryKey("TimeStamp", dateNow())
                .withString("user", chatData.getUser())
                .withString("chat", chatData.getChat());
            table.putItem(item);
        } catch (Exception e) {
            System.err.println("Create items failed.");
            System.err.println(e.getMessage());

        }
    }

    
} 
