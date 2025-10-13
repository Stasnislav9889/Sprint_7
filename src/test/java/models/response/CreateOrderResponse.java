package models.response;

import java.util.Objects;

public class CreateOrderResponse {

    private Integer track;

    public Integer getTrack() {
        return track;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CreateOrderResponse that = (CreateOrderResponse) o;
        return Objects.equals(track, that.track);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(track);
    }
}