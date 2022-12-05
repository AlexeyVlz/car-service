package carservice.controller.admin;

import carservice.model.branch.dto.BranchDto;
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
    public BranchDto createBranch(@RequestBody @Valid BranchDto branchDto) {
        log.info("Получен запрос к эндпоинту POST /branch, branchDto = " + branchDto);
        return branchService.createBranch(branchDto);
    }

    @PutMapping("/{id}")
    public BranchDto updateBranch(@PathVariable @Positive Long id,
                                  @RequestBody @Valid BranchDto branchDto) {
        log.info(String.format("Получен запрос к эндпоинту PUT /branch/%d, branchDto = %s", id, branchDto.toString()));
        return branchService.updateBranch(id, branchDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBranchById(@PathVariable @Positive Long id) {
        log.info("Получен запрос к эндпоинту DELETE /branch/" + id);
        branchService.deleteBranchById(id);
    }
}
