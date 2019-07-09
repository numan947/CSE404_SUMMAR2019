package numan947.com.rollwithit;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout ll;
    private ImageView imageView;
    private TextView textView;
    private ProgressBar progressBar;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.bindViews();
        this.addListeners();
        this.hideLoading();

    }

    private void addListeners() {
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.showLoading();
                Random random = new Random();
                int currentDiceVal = random.nextInt(6-1) + 1;

                Drawable drawable;
                switch (currentDiceVal){
                    case 1:
                        drawable = getDrawable(R.drawable.d1);
                        break;
                    case 2:
                        drawable = getDrawable(R.drawable.d2);
                        break;
                    case 3:
                        drawable = getDrawable(R.drawable.d3);
                        break;
                    case 4:
                        drawable = getDrawable(R.drawable.d4);
                        break;
                    case 5:
                        drawable = getDrawable(R.drawable.d5);
                        break;
                    case 6:
                        drawable = getDrawable(R.drawable.d6);
                        break;
                    default:
                        drawable = getDrawable(R.drawable.tesla_cat);
                }
                MainActivity.this.imageView.setImageDrawable(drawable);
                MainActivity.this.hideLoading();
                MainActivity.this.textView.setText(String.valueOf(currentDiceVal));
            }
        });
    }

    private void hideLoading() {
        this.ll.setVisibility(View.VISIBLE);
        this.progressBar.setVisibility(View.GONE);
    }

    private void showLoading() {
        this.ll.setVisibility(View.GONE);
        this.progressBar.setVisibility(View.VISIBLE);
    }

    private void bindViews() {
        this.button = findViewById(R.id.rollWithIt);
        this.imageView = findViewById(R.id.imageView);
        this.textView = findViewById(R.id.textView);
        this.progressBar = findViewById(R.id.progressBar);
        this.ll = findViewById(R.id.image_text_linearLayout);
    }
}
