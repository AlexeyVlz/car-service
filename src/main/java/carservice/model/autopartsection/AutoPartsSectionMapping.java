package carservice.model.autopartsection;

public class AutoPartsSectionMapping {

    public static AutoPartsSection toAutoPartsSection(AutoPartsSectionDtoIn section) {
        return new AutoPartsSection(section.getTitle());
    }

    public static AutoPartsSectionDtoOut toAutoPartsSectionDtoOut (AutoPartsSection section) {
        return new AutoPartsSectionDtoOut(section.getTitle());
    }
}
