package com.example.pf0803.pizza;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener,
        RadioGroup.OnCheckedChangeListener{

    private RadioGroup rdbGrupo;
    private Button btnCalcular;
    private CheckBox chkBorda;
    private Spinner spPgto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdbGrupo = (RadioGroup)findViewById(R.id.radioGroup);
        rdbGrupo.setOnCheckedChangeListener(this);

        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);

        chkBorda = (CheckBox)findViewById(R.id.chkBorda);

        spPgto = (Spinner) findViewById(R.id.spPgto);
    }

    public void sair(View view){
        finish();
    }

    @Override
    public void onClick(View v) {
        int idChecado = rdbGrupo.getCheckedRadioButtonId();
        int preco = 0;
        switch (idChecado){
            case R.id.rdbMussarela:
                preco = 10;
                break;
            case R.id.rdbCalabresa:
                preco = 15;
                break;
            case R.id.rdbPortuguesa:
                preco = 20;
        }

        if (chkBorda.isChecked()){
            preco += 5;
        }

        if (spPgto.getSelectedItemPosition() == 2){
            preco = (int)(preco * 0.9);
        }

        Toast.makeText(this, "Valor total R$" + preco + ",00!", Toast.LENGTH_LONG).show();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.rdbMussarela){
            chkBorda.setChecked(false);
            chkBorda.setEnabled(false);
        } else {
            chkBorda.setEnabled(true);
        }
    }
}
