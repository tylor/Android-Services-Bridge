package com.affinity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
        setContentView(R.layout.main);
        
        btnGetInfo = (Button) findViewById(R.id.get_info_button);
        btnGetInfo.setOnClickListener(this);
        
        btnCreateNode = (Button) findViewById(R.id.node_new_button);
        btnCreateNode.setOnClickListener(this);
    }
    
    public void onClick(View v) {
		switch (v.getId()) {
		case R.id.get_info_button:
			Log.d("main", Client.getNode(1));
			break;
    	case R.id.node_new_button:
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