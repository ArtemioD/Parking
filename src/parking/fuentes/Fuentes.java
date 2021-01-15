package parking.fuentes;

import java.awt.*;
import java.io.InputStream;

public final class Fuentes {
    private static Font font = null;
    public static String NFS = "NFS_font.ttf";

    //   Font.PLAIN = 0 , Font.BOLD = 1 , Font.ITALIC = 2
    public static Font fuente (String fontName, int estilo, float tamanio) {
        try {
            // se carga la fuente
            InputStream is = Fuentes.class.getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        }catch (Exception ex) {
            // si existe un error se carga fuente por defecto ARIAL
            System.err.println(fontName +  " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);
        }
        Font tfont = font.deriveFont(estilo, tamanio);
        return tfont;
    }

}
