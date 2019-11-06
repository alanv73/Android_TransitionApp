package edu.southhills.transitionapp;

import android.graphics.Color;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Transition customTransition = new CustomTransition();
        customTransition.setDuration(3000);

        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View v){
        createTransition();
    }

    public void createTransition(){



        Transition customTransition = new CustomTransition();
        Transition slide = new Slide(Gravity.TOP);
        customTransition.setDuration(3000);
        slide.setDuration(3000);

        ViewGroup root = findViewById(R.id.root_view);

        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(customTransition);
        transitionSet.addTransition(slide);
        transitionSet.setOrdering(TransitionSet.ORDERING_TOGETHER);
        transitionSet.addTarget(R.id.textView);


        TransitionManager.beginDelayedTransition(root, transitionSet);

        TextView textView = findViewById(R.id.textView);

        if(textView.getCurrentTextColor() == Color.BLACK) {
            textView.setText("GoodBye World!");
            textView.setTextColor(Color.RED);
            textView.setVisibility(View.INVISIBLE);
        } else {
            textView.setText("Hello World!");
            textView.setTextColor(Color.BLACK);
            textView.setVisibility(View.VISIBLE);
        }

    }
}