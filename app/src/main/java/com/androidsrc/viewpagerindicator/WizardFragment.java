package com.androidsrc.viewpagerindicator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WizardFragment extends Fragment {

	int wizard_page_position;
	
	public WizardFragment(int position) {
		this.wizard_page_position = position;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		int layout_id = R.layout.page1;
		switch (wizard_page_position) {
		case 0:
			layout_id = R.layout.page1;
			break;

		case 1:
			layout_id = R.layout.page2;
			break;
			
		case 2:
			layout_id = R.layout.page3;
			break;
			
		case 3:
			layout_id = R.layout.page4;
			break;
		}
		
		return inflater.inflate(layout_id, container, false);
	}

}
