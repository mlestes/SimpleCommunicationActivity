package com.coolcats.estesfuntimes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.coolcats.estesfuntimes.R;
import com.coolcats.estesfuntimes.util.StoredValue;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.coolcats.estesfuntimes.view.MainActivity.READ_KEY_1;

public class Activity2 extends AppCompatActivity {

    String previous;
    public static final String READ_KEY_2 = "READ_FROM_TWO";

    @BindView(R.id.act_2_rcv_txt)
    TextView recievedText;

    @BindView(R.id.act_2_prev_txt)
    TextView previousSentText;

    @BindView(R.id.act_2_edit_txt)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        ButterKnife.bind(this);

        //This is crude and dangerous, but works for this simple project
        previous = ((StoredValue) this.getApplication()).getPreviousValueTwo();
        String message = getIntent().getStringExtra(READ_KEY_1);
        if(previous != null) previousSentText.setText(previous);
        if(message != null) recievedText.setText(message);

    }

    @OnClick(R.id.act_2_send_btn)
    public void onClick(View view){

        Intent intent = new Intent(this, MainActivity.class);
        String msg = editText.getText().toString();
        if(msg.length() == 0) msg = null;
        intent.putExtra(READ_KEY_2, msg);
        previous = msg;
        previousSentText.setText(previous);
        ((StoredValue) this.getApplication()).setPreviousValueTwo(previous);
        startActivity(intent);
        finish();

    }

}