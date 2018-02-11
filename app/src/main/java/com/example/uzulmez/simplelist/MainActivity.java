package com.example.uzulmez.simplelist;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  private ListView MyList;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyList = (ListView) findViewById(R.id.L1);



        Log.i(TAG, "HOHOHOHOHOHOHOH" );



        final ArrayList<recipe> recipes = recipe.getlistfromfile("recipes.json" , this);

  /*      for (int i=0; i<Mystrarr.length; i++){
            recipe r = new recipe(Mystrarr[i],Mystrarr2[i]);
            recipes.add(r);
        }
*/
        //MyArrayAdapter<recipe> Adp = new MyArrayAdapter<recipe>(this, R.layout.row , R.id.T1 , recipes );

        MyList.setAdapter( new MyArrayAdaptor(this,recipes));

         MyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                 recipe selectedRecipe = recipes.get(i);


                 Toast.makeText(getApplicationContext(),
                         selectedRecipe.p1, Toast.LENGTH_SHORT).show();
             }

         });

    }

}
