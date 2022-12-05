package carservice.controller.user;

import carservice.model.branch.dto.BranchDto;
import carservice.service.user.UserBranchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@Slf4j
@Validated
@RequiredArgsConstructor
@RequestMapping(path = "/user/branch")
public class UserBranchController {

    private final UserBranchService branchService;

    @GetMapping("/{id}")
    public BranchDto getBranchById(@PathVariable @Positive Long id) {
        log.info("Получен запрос к эндпоинту GET /branch/" + id);
        return branchService.getBranchById(id);
    }
}
