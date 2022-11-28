package carservice.model.position;

public class PositionMapping {

    public static Position toPosition(PositionDto positionDto) {
        return new Position(positionDto.getTitle());
    }

    public static PositionDto toPositionDto(Position position) {
        return new PositionDto(position.getTitle());
    }
}
