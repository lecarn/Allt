package Tenta;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FakeData {

    List<DatabasStatik> FakeDatabas;
    private List<DatabasStatik> createDatabas() {

        DatabasStatik BlackFilament = new DatabasStatik("Black filament", 1, 120);
        DatabasStatik RedFilament = new DatabasStatik("Red Filament", 2, 125);
        DatabasStatik GreyFilament = new DatabasStatik("Grey Filament", 3, 115);

       FakeDatabas = new ArrayList<>();

        FakeDatabas.add(BlackFilament);
        FakeDatabas.add(RedFilament);
        FakeDatabas.add(GreyFilament);
        return FakeDatabas;
    }

    public  List<DatabasStatik> getDatabas(){
        if(FakeDatabas == null){
            FakeDatabas = createDatabas();
        }
        return FakeDatabas;
    }

    public void printToDatabas(DatabasStatik ds, int count, double price) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("testfile.txt", true)))){
            out.println(ds.getName()+"amount: "+count+"for the price: "+price);
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
