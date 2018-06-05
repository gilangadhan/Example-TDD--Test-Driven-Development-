/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package id.co.imastudio.menghitungvolume.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import id.co.imastudio.menghitungvolume.R;
import id.co.imastudio.menghitungvolume.model.VolumeModel;
import id.co.imastudio.menghitungvolume.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView {

    //Kenalin
    MainPresenter mainPresenter;
    EditText inputTinggi, inputPanjang, inputLebar;
    Button btnHitung;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hubungin
        mainPresenter = new MainPresenter(this);

        inputLebar = findViewById(R.id.inputLebar);
        inputPanjang = findViewById(R.id.inputPanjang);
        inputTinggi = findViewById(R.id.inputTinggi);
        btnHitung = findViewById(R.id.btnHitung);
        txtResult = findViewById(R.id.txtVolume);

        //ngapain
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do action
                String tinggi = inputTinggi.getText().toString().trim();
                String panjang = inputPanjang.getText().toString().trim();
                String lebar = inputLebar.getText().toString();
                mainPresenter.inputVolume(panjang,lebar,tinggi);
            }
        });
    }

    @Override
    public void lebarKosong(String error) {
        inputLebar.setError(error);
    }

    @Override
    public void tinggiKosong(String error) {
        inputTinggi.setError(error);
    }

    @Override
    public void panjangKosong(String error) {
        inputPanjang.setError(error);
    }

    @Override
    public void inputSuccess(VolumeModel volumeModel) {
        mainPresenter.hitungVolume(volumeModel);
    }

    @Override
    public void success(Double result) {
        txtResult.setText(String.valueOf(result));
    }
}
