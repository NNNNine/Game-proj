package map;
import java.util.Random;

public class RandomMap {
    public String[] allMap = {"/map/snow.png", "/map/plain.png", "/map/desert.png", "/map/arid.png"};

    public String getMap() {
        Random r = new Random();
        int temp_index = r.nextInt() % 4;

        return allMap[temp_index];
    }
}
