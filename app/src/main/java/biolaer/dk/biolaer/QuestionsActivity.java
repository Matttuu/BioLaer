package biolaer.dk.biolaer;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class QuestionsActivity extends AppCompatActivity {

 /*   String point;
    String navn;

    public QuestionsActivity(){

    }

    public QuestionsActivity(String point, String navn) {
        this.point = point;
        this.navn = navn;
    }

    public String getPoint() {
        return point;
    }

    public String getNavn() {
        return navn;
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
         Timer timer = new Timer();














        // Tvinger activityen til at være i Portrait orientation mode.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button optionsBtn = (Button) findViewById(R.id.optionsBtn);

        /** Kalder en "setOnClickListener" på "optionsBtn" der dikterer, hvad der skal ske,
         når brugeren klikker på cockwheel-ikonet i hjørnet */
        optionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent optionsActivity = new Intent(getApplicationContext(), OptionsActivity.class);
                startActivity(optionsActivity);
            }
        });
    }
}