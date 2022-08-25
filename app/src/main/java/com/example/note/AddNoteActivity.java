package com.example.note;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTitle;
    private EditText editDesc;
    private RadioGroup radioGroup;
    private Spinner spinnerNote;
    private NotesViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(NotesViewModel.class);
        editTitle = findViewById(R.id.editTextTitle);
        editDesc = findViewById(R.id.editTextTextDesc);
        spinnerNote = findViewById(R.id.spinnerDoW);
        radioGroup = findViewById(R.id.radioGroup);
    }

    public void onclickSaveNote(View view) {
        String title = editTitle.getText().toString().trim();
        String desc = editDesc.getText().toString().trim();
        int spinner = spinnerNote.getSelectedItemPosition();
        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioButtonId);
        int priority = Integer.parseInt(radioButton.getText().toString());
        if(isField(title, desc)){
            viewModel.insertNote(new Note(title, desc, spinner, priority));
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, R.string.isEmpty, Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isField(String title, String desc){
        return !title.isEmpty() & !desc.isEmpty();
    }
}