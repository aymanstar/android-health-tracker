/*
 * Copyright 2009 Dan Morrill
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.morrildl.health;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BloodPressureTracker extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bp_tracker);
	
		final EditText systolic = (EditText)findViewById(R.id.systolic);
		final EditText diastolic = (EditText)findViewById(R.id.diastolic);
		
		((Button)findViewById(R.id.save_button)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (saveBloodPressureRecord(systolic.getText().toString(), diastolic.getText().toString())) {
					finish();
				} else {
					displayDialog(R.string.bp_error);
				}
			}		
		});

		((Button)findViewById(R.id.cancel_button)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}		
		});
	}

	protected void displayDialog(int bp_error) {
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.bp_error_title);
		builder.setCancelable(false);
		builder.setPositiveButton(R.string.bp_dismiss, null);
		builder.setMessage(bp_error);
		builder.create().show();
	}

	protected boolean saveBloodPressureRecord(String systolic, String diastolic) {
		return true;
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
}
