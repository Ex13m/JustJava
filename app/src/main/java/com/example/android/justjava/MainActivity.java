package com.example.android.justjava;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

import java.text.NumberFormat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int capsOfCoffees = 0;
    private int priceOfCup = 5;
    private int stepCoffeesChange = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //display(capsOfCoffees);
        displayPrice(capsOfCoffees * priceOfCup);
        display(capsOfCoffees);
    }
    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        capsOfCoffees=capsOfCoffees+ stepCoffeesChange;
        display(capsOfCoffees);

    }
    /**
    * This method is called when the mines button is clicked.
    */

    public void decrement(View view) {
        capsOfCoffees=capsOfCoffees- stepCoffeesChange;
        display(capsOfCoffees);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+ number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        if (number>0) {
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
           capsOfCoffees=0;
           display(capsOfCoffees);
        }
        else{
            Toast.makeText(this, "Negative number of orders !", Toast.LENGTH_LONG).show();
            capsOfCoffees=0;
            priceTextView.setText("$"+priceOfCup);

        }
    }


}
