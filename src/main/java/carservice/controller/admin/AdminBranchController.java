package carservice.controller.admin;

import carservice.model.branch.BranchDtoIn;
import carservice.model.branch.BranchDtoOut;
import carservice.service.admin.branch.AdminBranchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@Slf4j
@Validated
@RequiredArgsConstructor
@RequestMapping(path = "/admin/branch")
public class AdminBranchController {

    private final AdminBranchService branchService;

    @PostMapping
    public BranchDtoOut createBranch(@RequestBody @Valid BranchDtoIn branchDtoIn) {
        log.info("Получен запрос к эндпоинту POST /branch, branchDto = " + branchDtoIn);
        return branchService.createBranch(branchDtoIn);
    }

    @PutMapping("/{id}")
    public BranchDtoOut updateBranch(@PathVariable @Positive Long id,
                                    @RequestBody @Valid BranchDtoIn branchDtoIn) {
        log.info(String.format("Получен запрос к эндпоинту PUT /branch/%d, branchDto = %s", id, branchDtoIn.toString()));
        return branchService.updateBranch(id, branchDtoIn);
    }

    @DeleteMapping("/{id}")
    public void deleteBranchById(@PathVariable @Positive Long id) {
        log.info("Получен запрос к эндпоинту DELETE /branch/" + id);
        branchService.deleteBranchById(id);
    }
}
