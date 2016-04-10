package com.niit.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IntentSampleActivity extends Activity implements View.OnClickListener {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnTime = (Button) findViewById(R.id.btnTime);
        Button btnDate = (Button) findViewById(R.id.btnDate);

        btnTime.setOnClickListener(this);
        btnDate.setOnClickListener(this);
    }

  public void onClick(View v) {
    Intent intent;

    switch(v.getId()) {
    case R.id.btnTime:
      intent = new Intent("com.niit.android.intent.action.showtime1");
        if (intent.resolveActivity(getApplicationContext().getPackageManager()) == null) {
        Toast.makeText(getApplicationContext(), "No suitable intent", Toast.LENGTH_LONG).show();
    }
        else {
      startActivity(intent); }
      break;
    case R.id.btnDate:

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "shareBody");
      startActivity(sharingIntent);
      break;
    }
  }
}