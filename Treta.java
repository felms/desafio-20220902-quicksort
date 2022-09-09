import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Treta implements Comparable<Treta>{

    private final String nomeDaTreta;
    private final Date ultimaOcorrencia;

    public Treta(String JSONObject) throws ParseException {
        String[] data = JSONObject.replaceAll("\\{|\\}|\"", "").split(",");
        nomeDaTreta = data[0].split(":")[1];
        String s = data[1].split(":")[1];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        ultimaOcorrencia = simpleDateFormat.parse(s);
    }

    @Override
    public int compareTo(Treta other) {
        return other.ultimaOcorrencia.compareTo(this.ultimaOcorrencia);
    }

    @Override
    public String toString() {
        return "{" +
                "\"treta\" : \"" + nomeDaTreta
                + "\", \"ultima_ocorrencia\": \""
                + new SimpleDateFormat("yyyy/MM/dd").format(ultimaOcorrencia)
                + "\"}";
    }
}
