package edu.umbc.Cat_Cost_Calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.NumberFormat;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    double totalCost;
    int numCats;
    String choiceF;
    String choiceL;
    int numV;
    int numB;
    int numG;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final EditText numberCats = (EditText) findViewById(R.id.numCats);
        final Spinner foodChoice = (Spinner) findViewById(R.id.foodType);
        final Spinner litterChoice = (Spinner) findViewById(R.id.catLitterSpinner);
        final EditText vetVisits = (EditText) findViewById(R.id.vetVisits);
        final EditText boardingDays = (EditText) findViewById(R.id.catBoarding);
        final EditText groomingVisits = (EditText) findViewById(R.id.groomerVisits);
        final CheckBox wormProt = (CheckBox) findViewById(R.id.heartWorm);
        final CheckBox fleaProt = (CheckBox) findViewById(R.id.fleaPre);
        final CheckBox rabieProt = (CheckBox) findViewById(R.id.rabiesVac);
        final CheckBox spayNeut = (CheckBox) findViewById(R.id.spayNeut);
        final Button calc = (Button) findViewById(R.id.calculateCost);
        final TextView costR = (TextView) findViewById(R.id.result);
        NumberFormat currency =NumberFormat.getCurrencyInstance();
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalCost = 0;
                numCats = Integer.parseInt(numberCats.getText().toString());
                choiceF = foodChoice.getSelectedItem().toString();
                choiceL = litterChoice.getSelectedItem().toString();
                numV = Integer.parseInt(vetVisits.getText().toString());
                numB = Integer.parseInt(boardingDays.getText().toString());
                numG = Integer.parseInt(groomingVisits.getText().toString());

                //switch food
                switch (choiceF){
                    case "Cheap Store Brand Cat Food":
                        totalCost += 72* numCats;
                        break;
                    case "Premium Name Brand Cat Food":
                        totalCost += 120* numCats;
                        break;
                    case "Healthy Choice Organic Cat Food":
                        totalCost += 192* numCats;
                        break;
                };
                //switch for litter
                switch (choiceL){
                    case "Clay: Clumping":
                        totalCost += (12.00 * 12) *numCats;
                        break;
                    case "Clay: Non-Clumping":
                        totalCost += (9.99 * 12) * numCats;
                        break;
                    case "Crystal":
                        totalCost += (16.69 *12) * numCats;
                        break;
                    case "Natural and Eco-Friendly":
                        totalCost += (14.99 * 12) * numCats;
                        break;
                }
                //assumes a standard 35 dollar checkup price
                totalCost += (numV * 35) * numCats;
                totalCost += numG * 40 * numCats;


                if(wormProt.isChecked())
                    totalCost += 84.89 * numCats;
                if(fleaProt.isChecked())
                    totalCost += 71.92 * numCats;
                if(rabieProt.isChecked())
                    totalCost += 10 * numCats;
                if(spayNeut.isChecked())
                    totalCost += 200 * numCats;
                if (numB > 365) {
                    Toast.makeText(MyActivity.this, "There are only 365 days in a year...", Toast.LENGTH_LONG).show();
                } else {
                    totalCost += (20 * numB) * numCats;
                    costR.setText("Your cat care cost for the year is valued at: "+ currency.format(totalCost));
                }
            }
    });
    }
}
