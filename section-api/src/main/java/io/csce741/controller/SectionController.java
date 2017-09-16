package io.csce741.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.csce741.entities.Section;

@RestController
public class SectionController {

	@Autowired
	private SectionService sectionService;

	@RequestMapping("/sections")
	public List<Section> getAllSections() {
		// return Extractor.sections;
		return sectionService.getAllSections();
	}

	@RequestMapping("/sections/{id}")
	public Section getSection(@PathVariable String id) {
		return sectionService.getSection(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/sections")
	public void addSection(@RequestBody Section section) {
		sectionService.addSection(section);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/sections/{id}")
	public void updateSection(@RequestBody Section section, @PathVariable String id) {
		sectionService.updateSection(id, section);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/sections/{id}")
	public void deleteSection(@PathVariable String id) {
		sectionService.deleteSection(id);
	}
}
