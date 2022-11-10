package service;

import model.dao.ProjectDao;
import model.dto.ProjectDto;
import repository.ProjectRepository;
import service.converter.ProjectConverter;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectService {

    private ProjectRepository repository;
    private ProjectConverter projectConverter;

    public ProjectService(ProjectRepository repository, ProjectConverter projectConverter) {
        this.repository = repository;
        this.projectConverter = projectConverter;
    }

    public ProjectDto create(ProjectDto projectDto) {
        ProjectDao projectDao = repository.create(projectConverter.to(projectDto));
        return projectConverter.from(projectDao);
    }

    public List<ProjectDto> findAll() {
        return repository.findAll().stream()
                .map(projectConverter::from)
                .collect(Collectors.toList());
    }

    public ProjectDto getByID(Integer id) throws Exception {
        ProjectDao projectDao = repository.getByID(id);
        if(projectDao == null) {
            throw new Exception("Project with such id does not find");
        }
        return projectConverter.from(projectDao);
    }

    public ProjectDto update(ProjectDto projectDto) {
        ProjectDao projectDao = repository.update(projectConverter.to(projectDto));
        return projectConverter.from(projectDao);
    }

    public void delete(ProjectDto projectDto) {
        repository.delete(projectConverter.to(projectDto));
    }

    public Integer salaryByProject(String projectName) {
        return repository.salaryByProject(projectName);
    }

    public List<Object[]> listOfProjects() {
        return repository.listOfProjects();
    }
}

