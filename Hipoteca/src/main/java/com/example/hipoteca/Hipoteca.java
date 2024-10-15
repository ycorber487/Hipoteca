package com.example.hipoteca;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Hipoteca extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Ejercicio Hipoteca");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);


        Label labelInteres = new Label("Annual Interest Rate: ");
        TextField interes = new TextField();
        grid.add(labelInteres, 0, 0);
        grid.add(interes, 1, 0);

        Label labelYears = new Label("Number of Years: ");
        TextField years = new TextField();
        grid.add(labelYears, 0, 1);
        grid.add(years, 1, 1);

        Label labelLoanAmount = new Label("Loan Amount: ");
        TextField loanAmount = new TextField();
        grid.add(labelLoanAmount, 0, 2);
        grid.add(loanAmount, 1, 2);

        Label labelMonthlyPayment = new Label("Monthly Payment: ");
        TextField monthlyPayment = new TextField();
        monthlyPayment.setEditable(false);
        grid.add(labelMonthlyPayment, 0, 3);
        grid.add(monthlyPayment, 1, 3);

        Label labelTotalPayment = new Label("Total Payment: ");
        TextField totalPayment = new TextField();
        totalPayment.setEditable(false);
        grid.add(labelTotalPayment, 0, 4);
        grid.add(totalPayment, 1, 4);


        Button boton = new Button("Calcular");
        grid.add(boton, 1, 5);


        boton.setOnAction(e -> {
                double i = Double.parseDouble(interes.getText());
                double h = Double.parseDouble(loanAmount.getText());
                int n = Integer.parseInt(years.getText());

                double r = i / (100 * 12);
                double m = (h * r) / (1 - Math.pow(1 + r, -12 * n));
                double total = m * 12 * n;

                // Mostrar los resultados redondeados a dos decimales
                monthlyPayment.setText(String.format("%.2f", m));
                totalPayment.setText(String.format("%.2f", total));

        });

        Scene scene = new Scene(grid, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
