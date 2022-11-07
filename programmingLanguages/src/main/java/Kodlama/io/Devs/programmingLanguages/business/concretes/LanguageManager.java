package Kodlama.io.Devs.programmingLanguages.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.programmingLanguages.business.abstracts.LanguageService;
import Kodlama.io.Devs.programmingLanguages.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.programmingLanguages.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public Language getById(int id) throws Exception {
		return languageRepository.getById(id);
	}

	@Override
	public void add(Language language) throws Exception {
		if (language.getName().isEmpty()) {
			throw new Exception("Programming language name cannot be empty.");
		}

		for (Language programmingLanguage : getAll()) {
			if (programmingLanguage.getName().equals(language.getName())) {
				throw new Exception("This programming language is already exists.");
			}
		}

		for (Language programmingLanguage : getAll()) {
			if (programmingLanguage.getId() == language.getId()) {
				throw new Exception("Enter a different id. This id is already exists.");
			}
		}

		languageRepository.add(language);
	}

	@Override
	public void update(Language language) throws Exception {
		languageRepository.update(language);
	}

	@Override
	public void delete(int id) throws Exception {
		languageRepository.delete(id);
	}

}
