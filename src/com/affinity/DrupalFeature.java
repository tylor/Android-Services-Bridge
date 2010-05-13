package com.affinity;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public interface DrupalFeature extends OnClickListener {
	Button btn = null;
	void init(LinearLayout layout);
}
