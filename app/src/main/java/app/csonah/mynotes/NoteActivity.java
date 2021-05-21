package app.csonah.mynotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.csonah.mynotes.models.DataManager;
import app.csonah.mynotes.models.NoteInfo;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<NoteInfo> notes = DataManager.getInstance().getNotes();
        List<String> noteTitles = new ArrayList();
        for(int i = 0; i < notes.size(); i++){
            noteTitles.add(notes.get(i).getTitle());
        }

        ListView noteList = findViewById(R.id.note_list);

        //create array adapter
        ArrayAdapter<NoteInfo> noteInfoArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, noteTitles);
        noteList.setAdapter(noteInfoArrayAdapter);

        noteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent noteContent = new Intent(NoteActivity.this, MainActivity.class);
                startActivity(noteContent);
            }
        });
    }
}