package org.rafaelbautista.study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddClass extends AppCompatActivity {
    private Button myButton;
    private EditText myEdit;

    public void addClass(String className){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("classes");

        myRef.setValue(className);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        myButton = (Button)findViewById(R.id.button);
        myEdit = (EditText)findViewById(R.id.edittext);

        myButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view)
                    {
                        addClass(myEdit.getText().toString());
                    }
                }
        );
    }
}
