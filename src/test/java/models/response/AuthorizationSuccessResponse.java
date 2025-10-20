package models.response;

import java.util.Objects;

public class AuthorizationSuccessResponse {

   private Integer id;

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AuthorizationSuccessResponse that = (AuthorizationSuccessResponse) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}