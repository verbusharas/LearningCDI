package lt.verbus.scopes;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Random;

@Named
public class LaimingoPatiekaloLoterija {

    @Inject
    private List<String> laimingiPatiekalai;

    private final Random random = new Random();

    public String trauktiLaimingajiPatiekala() {
        return laimingiPatiekalai.get(random.nextInt(8));
    }

}
