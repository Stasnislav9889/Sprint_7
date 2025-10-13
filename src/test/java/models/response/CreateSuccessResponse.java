package models.response;

import java.util.Objects;

public class CreateSuccessResponse {

   private Boolean ok;

    public Boolean getOk() {
        return ok;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CreateSuccessResponse that = (CreateSuccessResponse) o;
        return Objects.equals(ok, that.ok);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ok);
    }
}