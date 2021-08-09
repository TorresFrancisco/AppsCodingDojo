import java.util.HashMap;
import java.util.Set;

public class HashMapa {
    public static void main(String[] args) {
        HashMap<String, String> tracklist = new HashMap<String, String>();
        tracklist.put("Crimen", "Gustavo Cerati");
        tracklist.put("Profugos", "Soda Stereo");
        tracklist.put("Tratame Suavemente", "Soda Stereo");
        tracklist.put("Signos", "Soda Stereo");
        Set<String> keys = tracklist.keySet();
        for (String key : keys ) {
            System.out.println(key +" - "+tracklist.get(key)) ;
        }
        
    }
}

