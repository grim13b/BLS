package org.grim3lt.android.bls;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BLSActivity extends Activity {

    private static String BLS = "(´・ω・)人(・ω・`)バルス";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ("jp.r246.twicca.ACTION_EDIT_TWEET".equals(getIntent().getAction())) {
            fromTwicca();
        } else {
            toTwicca();
        }
        this.finish();
    }

    private void fromTwicca() {
        String timeLine = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        StringBuilder newTimeLine = new StringBuilder();

        newTimeLine.append(timeLine != null ? timeLine.substring(0, timeLine.length() / 2) : "");
        newTimeLine.append("(ry ");
        newTimeLine.append(BLS);

        getIntent().putExtra(Intent.EXTRA_TEXT, newTimeLine.toString());

        setResult(RESULT_OK, getIntent());
    }

    private void toTwicca() {
        Intent twiccaIntent = new Intent(Intent.ACTION_SEND);

        twiccaIntent.setPackage("jp.r246.twicca");
        twiccaIntent.setType("text/plain");

        twiccaIntent.putExtra(Intent.EXTRA_TEXT, BLS);

        try {
            startActivity(twiccaIntent);
        } catch (Exception e) {
            Toast.makeText(this, "すまん。バグだが細かいことは気にするな。", Toast.LENGTH_LONG).show();
        }
    }
}