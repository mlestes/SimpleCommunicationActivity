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

import static com.coolcats.estesfuntimes.view.Activity2.READ_KEY_2;

public class MainActivity extends AppCompatActivity {

    private String previous;
    public static final String READ_KEY_1 = "READ_FROM_ONE";

    @BindView(R.id.act_1_rcv_txt)
    TextView recievedText;

    @BindView(R.id.act_1_prev_txt)
    TextView previousSentText;

    @BindView(R.id.act_1_edit_txt)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //I know this is crude and dangerous, but works for what I want to do
        previous = ((StoredValue) this.getApplication()).getPreviousValueOne();
        if(previous != null) previousSentText.setText(previous);
        String message = getIntent().getStringExtra(READ_KEY_2);
        if(message != null) recievedText.setText(message);

    }

    @OnClick(R.id.act_1_send_btn)
    public void onClick(View view){

        Intent intent = new Intent(this, Activity2.class);
        String msg = editText.getText().toString();
        if(msg.length() == 0) msg = null;
        intent.putExtra(READ_KEY_1, msg);
        previous = msg;
        previousSentText.setText(previous);
        ((StoredValue) this.getApplication()).setPreviousValueOne(previous);
        startActivity(intent);
        finish();

    }

}