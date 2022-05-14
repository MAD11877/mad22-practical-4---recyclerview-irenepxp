package sg.edu.np.mad.madpractical;

import static android.view.View.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button flbutton = findViewById(R.id.fllwbutton);
        Button msgbutton = findViewById(R.id.msgbutton);
        User u = initUser();
        setText(u,flbutton);
        flbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(u.followed == true){
                    u.followed = false;
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();

                }
                else{
                    u.followed = true;
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();

                }
                setText(u,flbutton);
            }

        });
        msgbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act1 = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(act1);
            }
        });


        Intent receivingEnd = getIntent();
        Integer numbers = receivingEnd.getIntExtra("randomNo", 0);
        TextView mText = (TextView) findViewById(R.id.textView2);
        mText.setText("MAD" + " " + numbers.toString());
    }


    //initialize user
    public User initUser(){
        User u = new User("username","desc",1,true);
        return u;
    }

    // setting the text based on the condition
    public void setText(User u,Button flbutton){
        TextView txt = flbutton;
        if(u.followed == true){
            txt.setText("Follow");
        }
        else{
            txt.setText("Unfollow");
        }
    }
}