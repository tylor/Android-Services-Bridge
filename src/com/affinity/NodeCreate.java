package com.affinity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.affinity.Client;

public class NodeCreate extends Activity implements OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.node_create);
    }
    
    public void onClick(View v) {
		/*switch (v.getId()) {
		case R.id.get_info_button:
			Log.d("main", Client.getNode(1));
			break;
    	case R.id.node_new_button:
    		Log.d("main", Client.getNode(2));
			break;
		}*/
    }
}