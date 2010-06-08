package com.affinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.affinity.model.Node;

import android.util.Log;

// This should be an interface, and moved into ClientJson.java
public class Client {

	private static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	private static ArrayList<NameValuePair> getNodeValues() throws UnsupportedEncodingException {
	    ArrayList<NameValuePair> values = new ArrayList<NameValuePair>(1);
	    values.add(new BasicNameValuePair("method", "\"node.view\""));
	    values.add(new BasicNameValuePair("nid", "1"));
	    //UrlEncodedFormEntity entity = new UrlEncodedFormEntity(values, HTTP.UTF_8);
	    return values;
	}
	
	public static String getNode(int method) {
		String url = "http://10.0.2.2/services/json";
		DefaultHttpClient http_client = new DefaultHttpClient();
		HttpPost post_method = new HttpPost(url);
		try {
			HttpParams params = new BasicHttpParams();
			
			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
			HttpProtocolParams.setUseExpectContinue(params, false); 
			
            http_client.setParams(params);

            ArrayList<NameValuePair> values = new ArrayList<NameValuePair>(1);
            
            switch(1) {
            case 1:
            	values = getNodeValues();
            	break;
            }
            
            UrlEncodedFormEntity requestEntity = new UrlEncodedFormEntity(values, HTTP.UTF_8);
            
            post_method.setEntity(requestEntity);
		
			HttpResponse response;
			response = http_client.execute(post_method);

			Log.i("REST:Response Status line", response.getStatusLine().toString());

			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				InputStream instream = entity.getContent();
				String result = convertStreamToString(instream);
				Log.i("REST: result", result);
				
				JSONObject json = new JSONObject(result);
				Log.i("REST",  json.toString());

				boolean server_error = json.getBoolean("#error");
				
				if(server_error) {
					throw (new ClientProtocolException(json.getString("#data")));
				}
				
				JSONObject data = json.optJSONObject("#data");
			
				Log.i("REST", "Number of comments: " + data.length());

				instream.close();
				
				return data.getString("title");
			}

		} catch (Exception e) {
			Log.d("client", "Exception: " + e.getMessage());
		}
		
		return null;
	}
	
	private static ArrayList<NameValuePair> createNodeValues(Node node) throws UnsupportedEncodingException, JSONException {
	    ArrayList<NameValuePair> values = new ArrayList<NameValuePair>(1);
	    values.add(new BasicNameValuePair("method", "\"node.save\""));
	    
	    JSONObject nodeObject = new JSONObject();
	    nodeObject.put("title", node.getTitle());
	    nodeObject.put("body", node.getBody());
	    nodeObject.put("type", node.getType().getMachineName());
	    
	    values.add(new BasicNameValuePair("node", nodeObject.toString()));
	    return values;
	}
	
	public static void createNode(Node new_node) {
		String url = "http://10.0.2.2/services/json";
		DefaultHttpClient http_client = new DefaultHttpClient();
		HttpPost post_method = new HttpPost(url);
		try {
			HttpParams params = new BasicHttpParams();
			
			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
			HttpProtocolParams.setUseExpectContinue(params, false); 
			
            http_client.setParams(params);

            ArrayList<NameValuePair> values = new ArrayList<NameValuePair>(1);
            
            values = createNodeValues(new_node);
            
            UrlEncodedFormEntity requestEntity = new UrlEncodedFormEntity(values, HTTP.UTF_8);
            
            post_method.setEntity(requestEntity);
		
			HttpResponse response;
			response = http_client.execute(post_method);

			Log.i("REST:Response Status line", response.getStatusLine().toString());

			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				InputStream instream = entity.getContent();
				String result = convertStreamToString(instream);
				Log.i("REST: result", result);
				
				JSONObject json = new JSONObject(result);
				Log.i("REST",  json.toString());

				boolean server_error = json.getBoolean("#error");
				
				if(server_error) {
					throw (new ClientProtocolException(json.getString("#data")));
				}
				
				/*
				JSONObject data = json.optJSONObject("#data");
			
				Log.i("REST", "Number of comments: " + data.length());

				instream.close();
				
				return data.getString("title");
				*/
			}

		} catch (Exception e) {
			Log.d("client", "Exception in client: " + e.getMessage());
		}
		
		return;
	}
	
	private static ArrayList<NameValuePair> getFeaturesValues() throws UnsupportedEncodingException, JSONException {
	    ArrayList<NameValuePair> values = new ArrayList<NameValuePair>(1);
	    values.add(new BasicNameValuePair("method", "\"android.features\""));
	    
	    // JSONObject nodeObject = new JSONObject();
	    // nodeObject.put("nid", "1");
	    
	    values.add(new BasicNameValuePair("nid", "1"));

	    return values;
	}
	
	public static JSONObject getFeatures() {
		String url = "http://10.0.2.2/services/json";
		DefaultHttpClient http_client = new DefaultHttpClient();
		HttpPost post_method = new HttpPost(url);
		Log.d("client", "starting to look for features");
		try {
			HttpParams params = new BasicHttpParams();
			
			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
			HttpProtocolParams.setUseExpectContinue(params, false); 
			
            http_client.setParams(params);

            ArrayList<NameValuePair> values = new ArrayList<NameValuePair>(1);
            
            values = getFeaturesValues();
            
            UrlEncodedFormEntity requestEntity = new UrlEncodedFormEntity(values, HTTP.UTF_8);
            
            post_method.setEntity(requestEntity);
		
			HttpResponse response;
			response = http_client.execute(post_method);

			Log.i("REST:Response Status line", response.getStatusLine().toString());

			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				InputStream instream = entity.getContent();
				String result = convertStreamToString(instream);
				Log.i("REST: result", result);
				
				JSONObject json = new JSONObject(result);
				Log.i("REST",  json.toString());

				boolean server_error = json.getBoolean("#error");
				
				if(server_error) {
					throw (new ClientProtocolException(json.getString("#data")));
				}
				
				JSONObject data = json.optJSONObject("#data");
			
				//Log.i("REST", "Number of comments: " + data.length());

				instream.close();
				
				return data;
			}

		} catch (Exception e) {
			Log.d("client", "Exception in client: " + e.getMessage());
		}
		
		return null;
	}
}
