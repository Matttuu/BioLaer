package biolaer.dk.biolaer.Activities;

//Importerer nødvendige libraries
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import biolaer.dk.biolaer.BusinessLogic.Timer;
import biolaer.dk.biolaer.R;

public class QuestionsActivity extends AppCompatActivity {

    //Klassevariabler el. fields
    public static TextView actualPoint_textView;
    public static int pointT;
    public static TextView actualTime_textView;

    //Metode der tilføjer 100 point til dine samlede point
    public void addPoints(){
        pointT = Integer.parseInt(actualPoint_textView.getText().toString());
        actualPoint_textView.setText(pointT + 100 + "");
    }

    //Metode der parser brugerens point til integer og returnerer
    public int getPointT() {
        pointT = Integer.parseInt(actualPoint_textView.getText().toString());
        return pointT;
    }

    /**
     * Denne betode beregner din rang. Baseret på dine samlede point.
     */
    public String getRank(){
        String rank = ""; //Pr. default ingen rang

        if (pointT == 0){
            rank = "Noob";
        }
        else if (pointT == 100){
        rank = "Begynder";
        }
        else if (pointT >= 200 && pointT <= 500){
            rank = "Folkeskoleelev";
        }
        else if (pointT >= 600 && pointT <= 800){
            rank = "Gymnasieelev";
        }
        else if (pointT >= 900 && pointT <= 1200){
            rank = "Biologientusiast";
        }
       else {
            rank = "Pro!";
        }

        return rank;
    }

    Fragment1 fragment1 = new Fragment1();

    //Metode til at udelukke muligheden for gå tilbage, hvis der svares forkert på spg.
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    //Metode der fortsat fjerner navigationsbaren, selvom der klikkes et sted i aktiviteten.
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Timer timer = new Timer();

        actualTime_textView = (TextView) findViewById(R.id.actualTime_textView);


        //Lokale fields der forbinder til xml-filen
        Button optionsBtn = (Button) findViewById(R.id.optionsBtn);
        actualPoint_textView = (TextView) findViewById(R.id.actualPoint_textView);

        //Tvinger aktiviteten til at være i "Portrait orientation mode".
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Følgende kodestykke fjerner bl.a. navigationsbaren i bunden af aktiviteten.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);

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