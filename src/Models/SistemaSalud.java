package Models;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SistemaSalud {
    private Set<Persona> pacientes;
    private Integer cantDeReactivos;

    public SistemaSalud() {
        this.pacientes=new LinkedHashSet<>();
        this.cantDeReactivos=40;
    }

    public Set<Persona> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Set<Persona> pacientes) {
        this.pacientes = pacientes;
    }

    public Integer getCantDeReactivos() {
        return cantDeReactivos;
    }

    private void setCantDeReactivos(Integer cantDeReactivos) {
        this.cantDeReactivos = cantDeReactivos;
    }

    public void cargaPacientes(Persona p)throws Exception{
        if (p.getNroKit()> this.cantDeReactivos){
            throw new Exception("Ha superado la cantidad de reactivos disponibles");
        }
        else {
            this.pacientes.add(p);
            setCantDeReactivos(getCantDeReactivos()-p.getNroKit());
        }
    }
    public void agregaReactivos(Integer cant){
        setCantDeReactivos(getCantDeReactivos()+cant);
    }
    public void muestraPacientes(){
        for (Persona p : pacientes){
            System.out.println(p);
        }
    }

    public Map<Integer, String> testear(){
        Map<Integer, String> testeados = new HashMap<>();
        for (Persona p : pacientes){
            testeados.put(p.getNroKit(), "DNI: "+p.getDni() + " Temperatura: "+p.getTemperatura());
        }
        return testeados;
    }

    public void aislar(Persona p)throws Exception{
        if (p.getTemperatura()>=38){
            throw new Exception("El paciente con numero de kit: "+p.getNroKit()+", que vive en: "+p.getBarrio()+" hay que aislarlo urgente");
        }
        else {
            System.out.println("El paciente esta joya");
        }
    }

    public Boolean sanos(Persona p){
        if(p.getTemperatura()>=38){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "SistemaSalud{" +
                "pacientes=" + pacientes +
                '}';
    }
}
