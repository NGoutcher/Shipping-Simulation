import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;

import java.io.IOException;

public class MapsHandler {
    private static final String API_KEY = "FILL IN HERE";
    private static final GeoApiContext apiTool = new GeoApiContext.Builder().apiKey(API_KEY).build();

    public static long calculateDistance(String loc1, String loc2) throws ApiException, InterruptedException, IOException {
        DistanceMatrixApiRequest request = DistanceMatrixApi.newRequest(apiTool);
        DistanceMatrix result = request.origins(loc1).destinations(loc2).mode(TravelMode.TRANSIT).language("en-UK").await();

        long distanceApart = result.rows[0].elements[0].distance.inMeters;

        return distanceApart;
    }
}
