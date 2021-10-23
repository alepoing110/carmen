package controlador;

public class Funciones {
    public boolean sonNumeros(String x){        
        try{
            Double.valueOf(x);
            return true;
        }
        catch(Exception ex){
            return false;
        }        
    }
            
    public boolean sonLetras(String cadena){
        for (int i = 0; i < cadena.length(); i++){
            char caracter = cadena.toUpperCase().charAt(i);
            int valorASCII = (int)caracter;
            if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
                    return false; 
        }        
        return true;
    }
}
