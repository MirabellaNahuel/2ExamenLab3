import Models.Persona;
import Models.SistemaSalud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Nahuel", "Mirabella", 24, "Constitucion", "41307784", "Desempleado");
        Persona p2 = new Persona("Jairo", "Mirabella", 24, "Constitucion", "41307785", "Desempleado");
        Persona p3 = new Persona("Santiago", "Mirabella", 24, "Constitucion", "41307786", "Desempleado");
        Persona p4 = new Persona("David", "Mirabella", 24, "Constitucion", "41307787", "Desempleado");
        Persona p5 = new Persona("Nicolas", "Mirabella", 24, "Constitucion", "41307788", "Desempleado");
        Persona p6 = new Persona("Nahuel", "Mirabella", 24, "Constitucion", "41307784", "Desempleado");
        SistemaSalud sistema = new SistemaSalud();
        Boolean flag=false;
        Scanner teclado= new Scanner(System.in);
        do {
            try {
                sistema.cargaPacientes(p1);
                sistema.cargaPacientes(p2);
                sistema.cargaPacientes(p3);
                sistema.cargaPacientes(p4);
                sistema.cargaPacientes(p5);
                sistema.cargaPacientes(p6);
                flag=true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Integer opcion;
                System.out.println("¿TIENE MAS REACTIVOS PARA AGREGAR?");
                System.out.println("1- Si");
                System.out.println("2- No");
                opcion=teclado.nextInt();
                switch (opcion){
                    case 1:
                        teclado.nextLine();
                        Integer cant=0;
                        System.out.println("Ingrese cantidad de reactivos para sumar: ");
                        cant=teclado.nextInt();
                        sistema.agregaReactivos(cant);
                        break;
                    case 2:
                        System.out.println("No se puedo cargar el paciente");
                }
            }
        }while(flag==false);

        sistema.muestraPacientes();
        for (Map.Entry data : sistema.testear().entrySet()){
            System.out.println("NRO KIT DE PACIENTE: "+data.getKey());
            System.out.println("DATOS DE PACIENTE: "+data.getValue());
        }

        try{
            for (Persona p: sistema.getPacientes()) {
                sistema.aislar(p);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        List<String> sanosList=new ArrayList<>();
        List<String> ailadosList=new ArrayList<>();

        for (Persona p : sistema.getPacientes()) {
            if (sistema.sanos(p)){
                ///cargaArreglo(sanos, "Nombre: "+p.getNombre()+" Apellido: "+p.getApellido()+" DNI: "+p.getDni(),vSanos);
                sanosList.add("Nombre: "+p.getNombre()+"|| Apellido: "+p.getApellido()+"|| DNI: "+p.getDni());
            }
            else {
                ///cargaArreglo(aislados,"Nro de kit:"+p.getNroKit()+" Temperatura: "+p.getTemperatura()+" Barrio: "+p.getBarrio(),vAislados);
                 ailadosList.add("Nro de kit:"+p.getNroKit()+"|| Temperatura: "+p.getTemperatura()+"|| Barrio: "+p.getBarrio());
            }
        }
        System.out.println("ARREGLO DE SANOS");
        for (String str: sanosList){
            System.out.println(str);
        }
        System.out.println("ARREGLO DE AISLADOS");
        for (String str: ailadosList) {
            System.out.println(str);
        }

    }
}