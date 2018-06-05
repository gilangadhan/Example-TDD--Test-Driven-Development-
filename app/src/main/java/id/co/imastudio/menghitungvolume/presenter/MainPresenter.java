/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package id.co.imastudio.menghitungvolume.presenter;

import android.text.TextUtils;

import id.co.imastudio.menghitungvolume.model.VolumeModel;
import id.co.imastudio.menghitungvolume.view.MainView;

public class MainPresenter implements MainPresenterImpl {
    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void inputVolume(String panjang, String lebar, String tinggi) {
        if (lebar.isEmpty()) {
            mainView.lebarKosong("Tidak Boleh Kosong");
        } else if (panjang.isEmpty()) {
            mainView.panjangKosong("Tidak Boleh Kosong");
        } else if (tinggi.isEmpty()) {
            mainView.tinggiKosong("Tidak Boleh Kosong");
        } else {
            double p = Double.parseDouble(panjang);
            double l = Double.parseDouble(lebar);
            double t = Double.parseDouble(tinggi);
            VolumeModel model = new VolumeModel(p, t, l);
            mainView.inputSuccess(model);
        }
    }

    @Override
    public void hitungVolume(VolumeModel volumeModel) {
        double p = volumeModel.getPanjang();
        double l = volumeModel.getLebar();
        double t = volumeModel.getTinggi();
        double result = p * l * t;
        mainView.success(result);
    }
}
