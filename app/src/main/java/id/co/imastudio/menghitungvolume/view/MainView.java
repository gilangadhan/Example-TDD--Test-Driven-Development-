/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package id.co.imastudio.menghitungvolume.view;

import id.co.imastudio.menghitungvolume.model.VolumeModel;

public interface MainView {
    void lebarKosong(String error);
    void tinggiKosong(String error);
    void panjangKosong(String error);
    void inputSuccess(VolumeModel volumeModel);
    void success(Double result);
}
