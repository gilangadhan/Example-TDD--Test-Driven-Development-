/*
 * Copyright (c) 2018.
 * Gilang Ramadhan (gilang@imastudio.co.id)
 */

package id.co.imastudio.menghitungvolume.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import id.co.imastudio.menghitungvolume.model.VolumeModel;
import id.co.imastudio.menghitungvolume.view.MainView;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    private MainPresenter presenter;
    private MainView mainView;

    @Before
    public void setUp() throws Exception {
        mainView = mock(MainView.class);
        presenter = new MainPresenter(mainView);
    }

    @Test
    public void inputVolumePanjangError() {
        //actual
        String p = "", l = "2.0", t = "3.0";
        presenter.inputVolume(p, l, t);

        String error = "Tidak Boleh Kosong";
        verify(mainView).panjangKosong(error);
    }

    @Test
    public void inputVolumeLebarError() {
        //actual
        String p = "1", l = "", t = "3.0";
        presenter.inputVolume(p, l, t);

        String error = "Tidak Boleh Kosong";
        verify(mainView).lebarKosong(error);
    }

    @Test
    public void inputVolumeTinggiError() {
        //actual
        String p = "1", l = "2", t = "";
        presenter.inputVolume(p, l, t);

        String error = "Tidak Boleh Kosong";
        verify(mainView).tinggiKosong(error);
    }

    @Test
    public void inputVolumeSuccess() {
        //actual
        String p = "1", l = "2", t = "3";
        presenter.inputVolume(p, l, t);

        double panjang = Double.parseDouble(p);
        double lebar = Double.parseDouble(p);
        double tinggi = Double.parseDouble(p);

        verify(mainView).inputSuccess(new VolumeModel(panjang, tinggi, lebar));
    }


    @Test
    public void hitungVolume() {
        VolumeModel actual = new VolumeModel(8.0, 2.0, 2.0);
        presenter.hitungVolume(actual);
        double expected = 32.0;
        verify(mainView).success(expected);
    }
}