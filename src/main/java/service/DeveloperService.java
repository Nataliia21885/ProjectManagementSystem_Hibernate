package service;

import model.dao.DeveloperDao;
import model.dto.DeveloperDto;
import repository.DeveloperRepository;
import service.converter.DeveloperConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeveloperService {

    private DeveloperRepository repository;
    private DeveloperConverter developerConverter;

    public DeveloperService(DeveloperRepository repository, DeveloperConverter developerConverter) {
        this.repository = repository;
        this.developerConverter = developerConverter;
    }

    public DeveloperDto create(DeveloperDto developerDto) {
        DeveloperDao developerDao = repository.create(developerConverter.to(developerDto));
        return developerConverter.from(developerDao);
    }

    public List<DeveloperDto> findAll() {
        return repository.findAll().stream()
                .map(developerConverter::from)
                .collect(Collectors.toList());
    }

    public DeveloperDto getByID(Integer id) throws Exception {
        DeveloperDao developerDao = repository.getByID(id);
        if(developerDao == null) {
            throw new Exception("Developer with such id does not find");
        }
        return developerConverter.from(developerDao);
    }

    public DeveloperDto update(DeveloperDto developerDto) {
        DeveloperDao developerDao = repository.update(developerConverter.to(developerDto));
        return developerConverter.from(developerDao);
    }

    public void delete(DeveloperDto developerDto) {
        repository.delete(developerConverter.to(developerDto));
    }

    public List<DeveloperDto> developersByLanguage(String language) {
        List<DeveloperDto> developerDtoList = new ArrayList<>();
        List<DeveloperDao> list = repository.developersByLanguage(language);
        for (DeveloperDao dao : list) {
            developerDtoList.add(developerConverter.from(dao));
        }
        return developerDtoList;
    }

    public List<DeveloperDto> developersByLevel(String level) {
        List<DeveloperDto> developerDtoList = new ArrayList<>();
        List<DeveloperDao> list = repository.developersByLevel(level);
        for (DeveloperDao dao : list) {
            developerDtoList.add(developerConverter.from(dao));
        }
        return developerDtoList;
    }

    public List<DeveloperDto> getListOfProjectDevelopers(String projectName) {
        List<DeveloperDto> developerDtoList = new ArrayList<>();
        List<DeveloperDao> listOfProjectDevelopers = repository.quantityOfDevelopersInProject(projectName);
        for (DeveloperDao dao: listOfProjectDevelopers) {
            developerDtoList.add(developerConverter.from(dao));
        }
        return developerDtoList;
    }
}

