package edu.umbc.Cat_Cost_Calculator;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.*;

public class MainMenu extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        Button calcCostBtn = (Button)findViewById(R.id.calcCostBtn);
        Button addInfoBtn = (Button)findViewById(R.id.addinfobtn);
        Button gallBtn = (Button) findViewById(R.id.gall);

        calcCostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainMenu.this, MyActivity.class ));
            }
        });
        addInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainMenu.this, ListLinkActivity.class ));
            }
        });
        gallBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainMenu.this, FunCatPics.class ));
            }
        }));
    }
}
