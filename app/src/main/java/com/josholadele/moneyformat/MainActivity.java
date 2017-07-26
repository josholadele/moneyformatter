package com.josholadele.moneyformat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.josholadele.moneyformatter.Currency;
import com.josholadele.moneyformatter.MoneyFormatter;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = (EditText) findViewById(R.id.amount);
        final TextView textView = (TextView) findViewById(R.id.formatted_text);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String format = spinner.getSelectedItem().toString();
                try {
                    String text = MoneyFormatter.format(Double.parseDouble(charSequence.toString()),
                            format, Currency.valueOf(spinner1.getSelectedItem().toString()));
                    textView.setText(text);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error occured", Toast.LENGTH_SHORT).show();
                }


//                String convertedString = "";
//                try {
//                    convertedString = new DecimalFormat("#,###.##").format(Double.parseDouble(charSequence.toString()));
//                } catch (Exception ex) {
//
//                }
//                if (format.equalsIgnoreCase("ShortCode")) {
//                    String string = Currency.valueOf(spinner1.getSelectedItem().toString()).getShortCode()
//                            + " " + convertedString;
//                    textView.setText(string);
//                } else {
//                    String string = Currency.valueOf(spinner1.getSelectedItem().toString()).getSymbol()
//                            + " " + convertedString;
//                    textView.setText(string);
//                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        spinner = (Spinner) findViewById(R.id.format_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.FormatType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


        spinner1 = (Spinner) findViewById(R.id.currency);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.currency, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter1);

    }
}
