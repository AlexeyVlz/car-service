package carservice.controller.user;

import carservice.model.branch.BranchDtoOut;
import carservice.service.user.branch.UserBranchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@Slf4j
@Validated
@RequestMapping(path = "/user/branch")
public class UserBranchController {


    private final UserBranchService branchService;

    @Autowired
    public UserBranchController(@Qualifier("UserBranchServiceImpl") UserBranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("/{id}")
    public BranchDtoOut getBranchById(@PathVariable @Positive Long id) {
        log.info("Получен запрос к эндпоинту GET /branch/" + id);
        return branchService.getBranchById(id);
    }
}
