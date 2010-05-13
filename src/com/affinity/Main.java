package com.affinity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

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
        
        // This should eventually be cached
        // (Maybe cache is updated by a thread running in the background. Don't want to wait when starting.)
        //Client.getFeatures();
        
        
        Button b = new Button(this);
        b.setText("Dynamic Button");
        b.setId(1);
        b.setOnClickListener(this);
        
        //b.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        
        //btnCreateNode.setId(1);
        //btnCreateNode.setOnClickListener(this);
        
        //layout.addView(b);
        
        layout.addView(b);
        
        setContentView(layout);
    }
    
    public void onClick(View v) {
		switch (v.getId()) {
		/*case R.id.get_info_button:
			Log.d("main", Client.getNode(1));
			break;*/
    	case 1:
    		// Log.d("main", Client.getNode(2));
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