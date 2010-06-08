package com.affinity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.affinity.Client;
import com.affinity.model.ContentType;

public class NodeCreate extends Activity implements OnClickListener {
	private Button btnSave;
	
	public String buttonText() {
		return "Create node";
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.node_create);
        
        btnSave = (Button) findViewById(R.id.node_save_button);
        btnSave.setOnClickListener(this);
    }
    
    public void onClick(View v) {
		switch (v.getId()) {
		case R.id.node_save_button:
			final String title = String.valueOf(//
					((TextView) findViewById(R.id.Title)).getText());
			
			final String body = String.valueOf(//
					((TextView) findViewById(R.id.Body)).getText());
			
			ContentType new_node = new ContentType(title, body);
			
			Client.createNode(new_node);
			
			this.finish();
			break;
		}
    }
}