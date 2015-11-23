package by.khrapovitsky;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import by.khrapovitsky.model.Note;
import by.khrapovitsky.model.NoteRepository;

public class MainActivity extends AppCompatActivity {

    private List<Note> notes = NoteRepository.GetNotes();
    ArrayAdapter<Note> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView notesListView = (ListView) findViewById(R.id.NotesListView);

        adapter = new ArrayAdapter<Note>(this,
                android.R.layout.simple_list_item_1, notes);

        notesListView.setAdapter(adapter);
        registerForContextMenu(notesListView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select action");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_listview, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.action_delete:
                notes.remove(info.position);
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Note has successfully deleted", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_update:
                return true;
            default:
                super.onContextItemSelected(item);
        }
        return super.onContextItemSelected(item);
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

        if (id == R.id.action_create) {
            Intent intent = new Intent(this, NewNoteActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
