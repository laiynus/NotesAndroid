package by.khrapovitsky.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import by.khrapovitsky.R;
import by.khrapovitsky.model.Note;

public class CreateNewNote extends AppCompatActivity {

    Button createButton = null;
    EditText noteText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_note);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    /*
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.createNote:


                break;
            default:
                break;
        }
    }*/
}
