package carservice.model.position;

public class PositionMapping {

    public static Position toPosition(PositionDtoIn positionDtoIn) {
        return new Position(positionDtoIn.getTitle());
    }

    public static PositionDtoOut toPositionDtoOut(Position position) {
        return new PositionDtoOut(position.getTitle());
    }
}
