package com.example.cc_laundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }
//        TextInputEditText edt_nama = findViewById(R.id.edt_nama);
//        TextInputEditText edt_merek = findViewById(R.id.edt_merek);
//        TextInputEditText edt_alamat = findViewById(R.id.edt_alamat);
//        EditText edtMulti_catatan = findViewById(R.id.edtMulti_catatan);
//        Spinner spn_layanan = findViewById(R.id.spn_layanan);


    public void SendWa(View view){
        TextInputEditText edt_nama = findViewById(R.id.edt_nama);
        TextInputEditText edt_whatsapp = findViewById(R.id.edt_whatsapp);
        TextInputEditText edt_berat = findViewById(R.id.edt_berat);
        EditText edtMulti_catatan = findViewById(R.id.edtMulti_catatan);
        int harga = 12;
        Integer i = Integer.parseInt(String.valueOf(edt_berat.getText()));;
        String nama = edt_nama.getText().toString();

        Spinner spn_layanan = findViewById(R.id.spn_layanan);
            if (edt_nama.getText().toString().isEmpty() || edt_whatsapp.getText().toString().isEmpty()
                    || edt_berat.getText().toString().isEmpty() || edtMulti_catatan.getText().toString().isEmpty() || spn_layanan.getSelectedItemId() == 0) {
                Toast.makeText(InputActivity.this, "Lengkapi Semua Data", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    if(spn_layanan.getSelectedItem().toString() == "Cuci Saja"){
                        nama = "5000";

                    }

                    if(spn_layanan.getSelectedItem().toString() == "Cuci Strika"){
                        harga = 3000 * Integer.parseInt(String.valueOf(edt_berat.getText()));
                    }

                    if(spn_layanan.getSelectedItem().toString() == "Strika Saja"){
                        harga = 4000 * Integer.parseInt(String.valueOf(edt_berat.getText()));
                    }

                    String text = "Assalamualaikum Warahmatullahi Wabarakatuh."
                            + "\nList Pesanan."
                            + "\nNama : *" + nama + "*"
                            + "\nwa : *" + edt_whatsapp.getText().toString() + "*"
                            + "\nBerat cucian : *" + edt_berat.getText().toString() + "*"
                            + "\nLayanan : *" + spn_layanan.getSelectedItem().toString() + "*"
                            + "\nPesan : *" + edtMulti_catatan.getText().toString() + "*"
                            +"\nHarga : *" + harga + "*";



                    String toNumber = edt_whatsapp.getText().toString(); // Replace with mobile phone number without +Sign or leading zeros, but with country code




                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + toNumber + "&text=" + text));
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

    }
}