package com.example.latihan5;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


import java.io.*;

public class HelloController {
    @FXML
    TextField tfNISN;
    @FXML
    TextField tfNama;
    @FXML
    TextField tfAlamat;
    @FXML
    Button btnSubmit;
    @FXML
    TableView tvDataSiswa;
    @FXML
    Button btnSave;
    @FXML
    Button btnLoad;

    @FXML
    public void onButtonClicked(ActionEvent e) {
        if (e.getTarget().equals(btnSubmit)) {
            //Menambahkan data ke TableView saat button submit ditekan
            ObservableList<DataModel> data = tvDataSiswa.getItems();
            data.add(new DataModel(
                    tfNISN.getText(),
                    tfNama.getText(),
                    tfAlamat.getText()
            ));

            tfNISN.setText("");
            tfNama.setText("");
            tfAlamat.setText("");
        } else if (e.getTarget().equals(btnSave)){
            //Menulis data yang ada di TableView ke file bernama data
            //siswa.dat
            try {
                ObservableList<DataModel> data =tvDataSiswa.getItems();
                BufferedWriter writer = new BufferedWriter(new FileWriter("data-siswa.dat"));
                for (int i = 0; i < data.size(); i++){
                    writer.write(String.valueOf(data.get(i).getNisn()) +
                            "," + String.valueOf(data.get(i).getNama()) +
                            "," + String.valueOf(data.get(i).getAlamat()));
                    writer.newLine();
                }
                writer.close();
                //Menampilkan dialog jika berhasil menyimpan file
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText("Success Save Data to File");
                alert.showAndWait();
            } catch (IOException ex) {
                //Menampilkan dialog jika error saat menyimpan file
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Error IO Exception : " + ex.getMessage());
                alert.showAndWait();
            }
        } else if (e.getTarget().equals(btnLoad)) {
            //Membaca data yang ada di file data-siswa.dat ke TableView
            try {
                ObservableList<DataModel> data =
                        tvDataSiswa.getItems();
                data.clear();
                BufferedReader reader = new
                        BufferedReader(new FileReader("data-siswa.dat"));

                    String line;
                    while ((line = reader.readLine()) != null)
                    {
                        String[] temp = line.split(",");
                        DataModel dataModel = new
                                DataModel(temp[0], temp[1], temp[2]);
                        data.add(dataModel);
                    }
                    reader.close();
                    //Menampilkan dialoq jika berhasil membaca file
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setContentText("Success Load Data from Saved File");
                    alert.showAndWait();

            }catch (IOException ex) {
                //Menampilakan dialoq jika error saat membaca file
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Error IO Exception : " + ex.getMessage());
                alert.showAndWait();
            }
        }
    }
}
