package de.ufo.tracktable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Utils {
    private static Random r = new Random(12482375892837945L);
    public static List<UFO> createDummyData() {
        return List.of(generateUFO(), generateUFO(), generateUFO(), generateUFO(), generateUFO(), generateUFO(),
                generateUFO(), generateUFO(), generateUFO(), generateUFO(), generateUFO(), generateUFO(),
                generateUFO(), generateUFO(), generateUFO(), generateUFO());
    }

    private static UFO generateUFO() {
        final String[] ufoNames = new String[]{"Atlantis", "Tardis", "TotallyNotASpySatellite",
                "ChinaIsWatchting133732", "Milenium Falcon", "StarLink442012784749187",
                "MusksEgo69420", "Death Star", "XXAsisoaufuroiew1232112312321"};

        final String[] detectors = new String[]{"NSA", "CIA", "GermaHAHAHAHHANo", "China", "Unknown",
                "someWiredHacker133769420YoloSwag"};

        return new UFO(UUID.randomUUID().toString(),
                ufoNames[r.nextInt(ufoNames.length-1) + 1],
                r.nextInt(2) == 1,
                r.nextDouble(91),
                r.nextDouble(91),
                r.nextDouble(91),
                detectors[r.nextInt(detectors.length-1) + 1],
                LocalDateTime.now().minusHours(4).toString(),
                Math.abs(r.nextLong())+ 200);
    }
}
