public class CalculadoraEstadisticas {

    public void calcularEstadisticas(double[] numeros) {
        double media = calcularMedia(numeros);
        double varianza = calcularVarianza(numeros, media);
        double desviacion = calcularDesviacionEstandar(varianza);

        imprimirResultados(media, varianza, desviacion);
    }

    private double calcularMedia(double[] numeros) {
        double suma = 0;
        for (double num : numeros) {
            suma += num;
        }
        return suma / numeros.length;
    }

    private double calcularVarianza(double[] numeros, double media) {
        double suma = 0;
        for (double num : numeros) {
            suma += Math.pow(num - media, 2);
        }
        return suma / numeros.length;
    }

    private double calcularDesviacionEstandar(double varianza) {
        return Math.sqrt(varianza);
    }

    private void imprimirResultados(double media, double varianza, double desviacion) {
        System.out.println("Media: " + media);
        System.out.println("Varianza: " + varianza);
        System.out.println("Desviación estándar: " + desviacion);
    }
}
