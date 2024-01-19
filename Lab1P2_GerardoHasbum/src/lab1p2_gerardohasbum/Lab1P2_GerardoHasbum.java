package lab1p2_gerardohasbum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collection;

public class Lab1P2_GerardoHasbum {

    static public Scanner scr = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Pattern simcorreo = Pattern.compile("-,_,&,$,%", Pattern.CASE_INSENSITIVE);
        char resus = 's';
        while (resus == 's' || resus == 'S') {
            int contus = 0;
            System.out.println("*****MENU*****");
            System.out.println("1. Ingresar Usuario");
            System.out.println("2. Listar todo");
            System.out.println("3. Listar por dominio");
            System.out.println("Ingrese su opcion: ");
            int resmen = scr.nextInt();
            switch (resmen) {
                case 1:
                    System.out.println("Ingrese su nombre: ");
                    String nombre = scr.next();
                    System.out.println("Ingrese su apellido: ");
                    String apellido = scr.next();
                    System.out.println("Ingrese su fecha de nacimiento(yyyy/mm/dd): ");
                    String fecha = scr.next();
                    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
                    Date fena = sd.parse(fecha);
                    Date hoy = new Date();
                    int yearus = hoy.getYear() - fena.getYear();
                    int monthus = hoy.getMonth() - fena.getMonth();
                    int dayus = hoy.getDay() - fena.getDay();
                    Date edad = new Date(yearus, monthus, dayus);
                    int year = edad.getYear();
                    int month = edad.getMonth();
                    int day = edad.getDay();
                    String edadfin = "Years: " + year + "   Months: " + month + "    Days: " + day;
                    System.out.println("Ingrese su correo electronico: ");
                    String correo = scr.next();
                    String regex = "^[a-zA-Z0-9._%&$+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(correo);
                    if (matcher.matches() == false) {
                        System.out.println("Hubo un error ingresando el correo \nregresandolo a la pagina de inicio");
                        break;
                    }
                    System.out.println("Ingrese su password: ");
                    String contra = scr.next();
                    Pattern passpatt = Pattern.compile("^[a-zA-Z0-9._%&$+-?<>!]{8,}$");
                    Matcher matchpatt = passpatt.matcher(contra);
                    if (matchpatt.matches() == false) {
                        System.out.println("Hubo un error ingresando la password\nregresandolo a la pagina de inicio");
                        break;
                    }
                    boolean verdom = true;
                    for (int i = 0; i < usuarios.size(); i++) {
                        Usuario temp = usuarios.get(i);
                        if (temp.Correo.contains(correo)) {
                            verdom = false;
                        }
                    }
                    if (verdom == false) {
                        break;
                    }
                    Usuario nuevo = new Usuario(nombre, apellido, edadfin, correo, contra);
                    usuarios.add(nuevo);
                    break;

                case 2:
                    PrintAT(usuarios);
                    break;

                case 3:
                    PrintAD(usuarios);
                    break;
            }
            System.out.println("Desea probar otro programa? [s/n]");
            resus = scr.next().charAt(0);
        }
    }

    public static void PrintAT(ArrayList<Usuario> usuario) {
        for (int i = 0; i < usuario.size(); i++) {
            System.out.println(i + 1 + ".- " + usuario.get(i).toString());
        }
    }

    public static void PrintAD(ArrayList<Usuario> usuario) {
        int cont = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < usuario.size(); j++) {
                Usuario temporal = usuario.get(j);
                switch (i) {
                    case 1:
                        if (temporal.Correo.contains("Gmail") || temporal.Correo.contains("gmail")) {
                            System.out.println(cont + 1 + ".- " + temporal.toString());
                        }
                        cont++;
                        break;

                    case 2:
                        if (temporal.Correo.contains("Outlook") || temporal.Correo.contains("outlook")) {
                            System.out.println(cont + 1 + ".- " + temporal.toString());
                        }
                        cont++;
                        break;

                    case 3:
                        if (temporal.Correo.contains("Yahoo") || temporal.Correo.contains("yahoo")) {
                            System.out.println(cont + 1 + ".- " + temporal.toString());
                        }
                        cont++;
                        break;

                    case 4:
                        if (temporal.Correo.contains("iCloud") || temporal.Correo.contains("icloud")) {
                            System.out.println(cont + 1 + ".- " + temporal.toString());
                        }
                        cont++;
                        break;

                    case 5:
                        if (temporal.Correo.contains("ProtonMail") || temporal.Correo.contains("protonmail")) {
                            System.out.println(cont + 1 + ".- " + temporal.toString());
                        }
                        cont++;
                        break;

                    case 6:
                        if (temporal.Correo.contains("fastmail") || temporal.Correo.contains("FastMail")) {
                            System.out.println(cont + 1 + ".- " + temporal.toString());
                        }
                        cont++;
                        break;
                }
            }

        }
    }
}
