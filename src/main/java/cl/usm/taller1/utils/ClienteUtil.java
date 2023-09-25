package cl.usm.taller1.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClienteUtil{
        public static boolean isRutValido(String rut){
            Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
            Matcher matcher = pattern.matcher(rut);
            if (!matcher.matches()) {
                return false;
            }
            String[] stringRut = rut.split("-");
            return stringRut[1].toLowerCase().equals(dv(stringRut[0]));
        }
        private static String dv(String rut) {
            int M = 0, S = 1, T = Integer.parseInt(rut);
            for (; T != 0; T = (int) Math.floor(T / 10)) {
                S = (S + T % 10 * (9 - M++ % 6)) % 11;
            }
            return (S > 0) ? String.valueOf(S - 1) : "k";
        }
        public static boolean isValidEstado(String estado) {
            List<String> valoresValidos = Arrays.asList("Habilitado", "ConDeuda", "EnListaNegra");
            return valoresValidos.contains(estado);
        }
}
