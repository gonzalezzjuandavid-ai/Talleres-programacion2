import java.util.Scanner;

public class ContadorVocalesConsonantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Contador de Vocales y Consonantes ===");
        System.out.print("Ingrese una palabra (en minusculas, sin simbolos ni numeros): ");
        String palabra = scanner.nextLine();

        int vocales = 0;
        int consonantes = 0;

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                vocales++;
            } else if (letra >= 'a' && letra <= 'z') {
                consonantes++;
            }
        }

        System.out.println("La palabra \"" + palabra + "\" tiene:");
        System.out.println("Vocales: " + vocales);
        System.out.println("Consonantes: " + consonantes);

        scanner.close();
    }
}
