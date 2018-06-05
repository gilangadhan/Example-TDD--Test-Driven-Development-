/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package id.co.imastudio.menghitungvolume.presenter;

import id.co.imastudio.menghitungvolume.model.VolumeModel;

public interface MainPresenterImpl {
   void inputVolume(String panjang, String lebar, String tinggi);
   void hitungVolume(VolumeModel volumeModel);
}
