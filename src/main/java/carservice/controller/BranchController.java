package carservice.controller;

import carservice.model.branch.BranchDto;
import carservice.model.branch.BranchMapping;
import carservice.service.BranchService;
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
@RequestMapping(path = "/branch")
public class BranchController {

    private final BranchService branchService;

    @PostMapping
    public BranchDto createBranch(@RequestBody @Valid BranchDto branchDto) {
        log.info("Получен запрос к эндпоинту POST /branch, branchDto = " + branchDto);
        return branchService.createBranch(branchDto);
    }

    @GetMapping("/{id}")
    public BranchDto getBranchById(@PathVariable @Positive Long id) {
        log.info("Получен запрос к эндпоинту GET /branch/" + id);
        return BranchMapping.toBranchDto(branchService.getBranchById(id));
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
