package com.example.sahilgogna.drinksurvey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sahilgogna.drinksurvey.Model.ClientDetails;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Spinner spinner;
    ArrayAdapter adapter;
    Button resultButton, newButton, addButton;
    String selectedDrinkType;
    RadioGroup radioGroup;
    EditText clientNumber, noOfCups;
    ArrayList<ClientDetails> list = new ArrayList<>();
//    ArrayList<RadioButton> radioButtonIds = new ArrayList<>();
    ArrayList<RadioButton> idList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        spinner = findViewById(R.id.drinkSpinner);
        resultButton = findViewById(R.id.results_button);
        addButton = findViewById(R.id.add_button);
        newButton = findViewById(R.id.new_button);
        resultButton.setOnClickListener(this);
        newButton.setOnClickListener(this);
        addButton.setOnClickListener(this);

        adapter = ArrayAdapter.createFromResource(this, R.array.drinkTypeArray,
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        radioGroup = findViewById(R.id.radioGroup);
        clientNumber = findViewById(R.id.clientNumberInput);
        noOfCups = findViewById(R.id.numberOfCupsInput);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedDrinkType = parent.getItemAtPosition(position).toString();
        addRadioButtons();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.results_button:
                Intent intent = new Intent(this, Results.class);
                startActivity(intent);
                break;

            case R.id.new_button:
                clientNumber.setText(null);
                noOfCups.setText(null);
                radioGroup.removeAllViews();
                addRadioButtons();
                break;

            case R.id.add_button:
//                ClientDetails clientDetails = new ClientDetails();
//                clientDetails.setClientNumber(Integer.parseInt(clientNumber.getText().toString()));
//                clientDetails.setDrinkType(selectedDrinkType);
//                clientDetails.setDrink();
                String result="";
                int selectedId = radioGroup.getCheckedRadioButtonId();
                  for(RadioButton button: idList){
                      if(button.getId() == selectedId){
                          result = button.getText().toString();
                      }
                  }

                Toast.makeText(this,result,Toast.LENGTH_LONG).show();

        }
    }

    public void addRadioButtons() {
        radioGroup.removeAllViews();
        int name = getResources().getIdentifier("array/" + selectedDrinkType, null, getPackageName());
        String[] values = getResources().getStringArray(name);
        int number = values.length;
        for (int i = 0; i < 1; i++) {
//            RadioGroup ll = new RadioGroup(this);
//            ll.setOrientation(LinearLayout.HORIZONTAL);
            for (int k = 0; k < number; k++) {
                RadioButton rdbtn = new RadioButton(this);
                rdbtn.setId(View.generateViewId());
                rdbtn.setText(values[k]);
//                radioButtonIds.add(rdbtn);
                idList.add(rdbtn);
                radioGroup.addView(rdbtn);
            }
//            ((ViewGroup) findViewById(R.id.radioGroup)).addView(ll);
        }
    }
}
