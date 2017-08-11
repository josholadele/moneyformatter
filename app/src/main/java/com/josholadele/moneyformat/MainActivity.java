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

    Spinner formatTypeSpinner;
    Spinner currencySpinner;

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
                if (charSequence.length() > 0) {
                    String format = formatTypeSpinner.getSelectedItem().toString();
                    String currency = currencySpinner.getSelectedItem().toString();
                    try {
                        String text = MoneyFormatter.format(Double.parseDouble(charSequence.toString()),
                                format, Currency.valueOf(currency));
                        textView.setText(text);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Error occurred", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        formatTypeSpinner = (Spinner) findViewById(R.id.format_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.FormatType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        formatTypeSpinner.setAdapter(adapter);


        currencySpinner = (Spinner) findViewById(R.id.currency);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.currency, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(adapter1);

    }
}
