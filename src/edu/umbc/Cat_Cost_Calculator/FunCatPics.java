package edu.umbc.Cat_Cost_Calculator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import edu.umbc.Cat_Cost_Calculator.R;

/**
 * Created by Joe Bennett on 11/20/2015.
 */
public class FunCatPics extends Activity {

    Integer catPics[] ={R.drawable.cat1,R.drawable.cat2,R.drawable.cat3};
    ImageView pic;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fun_pics);
        GridView grid = (GridView) findViewById(R.id.gridView);
        final ImageView pic = (ImageView) findViewById(R.id.ImgLarge);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pic.setImageResource(catPics[position]);
            }
        });
    }
    public class ImageAdapter extends BaseAdapter {
        private Context context;
        public ImageAdapter(Context c){
            context = c;
        }
        @Override
        public int getCount() {
            return catPics.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(catPics[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330,300));
            return pic;
        }
    }

}