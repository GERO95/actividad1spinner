package com.example.actividad1spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[]frutas={"piña","manzana","pera","banana","uva"};
    int[]imagenfruta={R.drawable.pinia, R.drawable.manzana, R.drawable.pera, R.drawable.banana, R.drawable.uva};
    Spinner spFruta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spFruta=findViewById(R.id.spFruta);
        FrutaAdapter adaptador1=new FrutaAdapter();
        spFruta.setAdapter(adaptador1);


    }
    public void recuperar(View v){

        Toast.makeText(this,spFruta.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();

    }

    private class FrutaAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return frutas.length;
        }

        @Override
        public Object getItem(int position) {
            return frutas[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            convertView = inflater.inflate(R.layout.itemspinner, null);
            ImageView ivfruta = convertView.findViewById(R.id.ivfruta);
            TextView tvfruta = convertView.findViewById(R.id.tvfruta);
            ivfruta.setImageResource(imagenfruta[position]);
            tvfruta.setText(frutas[position]);
            return convertView;


        }
    }
}