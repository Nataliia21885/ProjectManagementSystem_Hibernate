package service;

import model.dao.SkillDao;
import model.dto.SkillDto;
import repository.SkillRepository;
import service.converter.SkillConverter;

import java.util.List;
import java.util.stream.Collectors;

public class SkillService {
    private SkillRepository repository;
    private SkillConverter skillConverter;

    public SkillService(SkillRepository repository, SkillConverter skillConverter) {
        this.repository = repository;
        this.skillConverter = skillConverter;
    }

    public SkillDto create(SkillDto skillDto) {
        SkillDao skillDao = repository.create(skillConverter.to(skillDto));
        return skillConverter.from(skillDao);
    }

    public List<SkillDto> findAll() {
        return repository.findAll().stream()
                .map(skillConverter::from)
                .collect(Collectors.toList());
    }

    public SkillDto getByID(Integer id) throws Exception {
        SkillDao skillDao = repository.getByID(id);
        if(skillDao == null) {
            throw new Exception("Skill with such id does not find");
        }
        return skillConverter.from(skillDao);
    }

    public SkillDto update(SkillDto skillDto) {
        SkillDao skillDao = repository.update(skillConverter.to(skillDto));
        return skillConverter.from(skillDao);
    }

    public void delete(SkillDto skillDto) {
        repository.delete(skillConverter.to(skillDto));
    }

}

