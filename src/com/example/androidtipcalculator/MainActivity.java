package com.example.androidtipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText etAmount;
	private TextView tvLabeloutTip;
	private EditText etCustomtip;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAmount = (EditText) findViewById(R.id.etAmount);
        tvLabeloutTip = (TextView) findViewById(R.id.tvLabelOutTip);
        etCustomtip = (EditText) findViewById(R.id.etCustomtip);
    }
    
    public void onSubmitLow(View v) {
    	showTip(0.10);
    }
    
    public void onSubmitMed(View v) {
    	showTip(0.15);    	
    }
    
    public void onSubmitHigh(View v) {
    	showTip(0.20);
    }
    
    public void onSubmit(View v){
    	if(etCustomtip.getText().toString().equals("")){
    		Toast.makeText(getApplicationContext(), "Please enter custom tip %!", Toast.LENGTH_SHORT).show();
    		return;
    	}
    	String etCustomtipValue = etCustomtip.getText().toString();
    	Double tip = Double.parseDouble(etCustomtipValue)/100;
    	showTip(tip);
    }
    
    public void showTip(Double tip){
    	if(etAmount.getText().toString().equals("")){
    		Toast.makeText(getApplicationContext(), "Please enter an amount!", Toast.LENGTH_SHORT).show();
    		return;
    	}
    	String etAmountValue = etAmount.getText().toString();
    	Double tipAmount = Double.parseDouble(etAmountValue) * tip;
    	tvLabeloutTip.setText("$" + tipAmount.toString());
    }
}
