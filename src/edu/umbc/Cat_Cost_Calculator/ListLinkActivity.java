package edu.umbc.Cat_Cost_Calculator;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListLinkActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] catLinks = {"Happy Cat Tips", "New Cat Owner Tips", "Cat Games", "General Cat Tips"};

        setListAdapter(new ArrayAdapter<String>(this, R.layout.cat_list, R.id.CatList, catLinks));
    }
    protected void onListItemClick(ListView l, View v, int position, long id){
        switch(position){
            case 0:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.petmd.com/cat/care/evr_ct_new_kitten_tips")));
                break;
            case 1:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.petmd.com/cat/care/evr_ct_tips_for_new_cat_owners")));
                break;
            case 2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nutro.com/natural-cat-food/cat-resources/games-to-play-with-your-cat.aspx")));
                break;
            case 3:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.animalplanet.com/pets/general-cat-care-tips/")));
                break;
        }
    }
}
