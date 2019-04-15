package io.intelligence.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.intelligence.ppmtool.domain.Project;
import io.intelligence.ppmtool.exceptions.ProjectIdException;
import io.intelligence.ppmtool.repositories.ProjectRepository;
import io.intelligence.ppmtool.web.ProjectController;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdate(Project project) {
		
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		}
		catch(Exception e) {
			throw new ProjectIdException("Project Id" + project.getProjectIdentifier().toUpperCase()+" already exists.");
		}
		
		
	}
	
}
