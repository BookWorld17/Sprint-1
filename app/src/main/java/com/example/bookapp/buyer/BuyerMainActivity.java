package com.example.bookapp.buyer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bookapp.R;
import com.example.bookapp.SessionManager;

public class BuyerMainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyer_main_activity);
        SessionManager session = new SessionManager(this);
        Button logout = (Button)findViewById(R.id.logoutBtn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.logoutUser();
            }
        });
    }

}
