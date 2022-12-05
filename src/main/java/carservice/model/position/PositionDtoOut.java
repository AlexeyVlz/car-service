package carservice.model.position;

import lombok.Data;

@Data
public class PositionDtoOut {

    private String title;

    public PositionDtoOut(String title) {
        this.title = title;
    }
}
