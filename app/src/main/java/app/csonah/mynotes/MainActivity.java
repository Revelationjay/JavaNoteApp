package app.csonah.mynotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import app.csonah.mynotes.models.CourseInfo;
import app.csonah.mynotes.models.DataManager;
import app.csonah.mynotes.models.NoteInfo;

public class MainActivity extends AppCompatActivity {
    public static final String NOTE_INFO = "NOTE_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spinner = findViewById(R.id.spinner);

        List<CourseInfo> listOfCourses = DataManager.getInstance().getCourses();
        ArrayAdapter<CourseInfo> coursesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listOfCourses);
        coursesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(coursesAdapter);
        NoteInfo data = getPassedExtra();

        EditText title = findViewById(R.id.text_note_title);
        EditText content = findViewById(R.id.text_note_text);

        title.setText(data.getTitle());
        content.setText(data.getText());
    }

    private NoteInfo getPassedExtra() {
        Intent i = getIntent();
        NoteInfo data = i.getParcelableExtra(NOTE_INFO);
        return data;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}