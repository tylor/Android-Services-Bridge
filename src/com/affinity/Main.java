package com.affinity;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.affinity.NodeCreate;

import com.affinity.Client;

public class Main extends Activity implements OnClickListener {
	private Button btnGetInfo;
	private Button btnCreateNode;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // This is how to do it with XML
        //btnGetInfo = (Button) findViewById(R.id.get_info_button);
        //btnGetInfo.setOnClickListener(this);

        // Would like to do it this way, with XML.
        // LinearLayout layout = (LinearLayout) findViewById(R.id.main_layout);
        
        // In the meantime, create the layout programmatically.
        LinearLayout layout = new LinearLayout(this);
        
        //TextView affinity_text = new TextView(this);
        
        //affinity_text.setText("Available Features");
        //affinity_text.setTextSize(25);
        //affinity_text.setId(2);
        //affinity_text.setLayoutParams();
        
        //affinity_text.setPadding(40, 0, 0, 40);
        //affinity_text.setGravity(0);
        
        //layout.addView(affinity_text, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        
        // This should eventually be cached
        // (Maybe cache is updated by a thread running in the background. Don't want to wait when starting.)
        JSONObject features = Client.getFeatures();
		
        // This needs to be abstracted to handle all features.
		String nodefeature = null;
		try {
			nodefeature = features.get("node").toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(nodefeature.equals("true")) {
			NodeCreate feature = new NodeCreate();
		    
		    Button b = new Button(this);
		    b.setText(feature.buttonText());
		   // b.setPadding(0, 100, 0, 0);
		   // b.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		    // Must be a good way to do this.
		    b.setId(1);
		    b.setOnClickListener(this);
		    
		    layout.addView(b, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		}
        setContentView(layout);
    }
    
    public void onClick(View v) {
		switch (v.getId()) {
		/*case R.id.get_info_button:
			Log.d("main", Client.getNode(1));
			break;*/
    	case 1:
    		try {
	    		Intent intentEdit = new Intent(this, NodeCreate.class);
				startActivity(intentEdit);
    		} catch(Exception e) {
    			Log.d("main", "Failed to launch: " + e.getMessage());
    		}
			break;
		}
    }
}