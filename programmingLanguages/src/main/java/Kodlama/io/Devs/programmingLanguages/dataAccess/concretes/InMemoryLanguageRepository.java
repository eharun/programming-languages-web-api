package Kodlama.io.Devs.programmingLanguages.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.programmingLanguages.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.programmingLanguages.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> languages;

	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1, "Java"));
		languages.add(new Language(2, "C#"));
		languages.add(new Language(3, "PHP"));
		languages.add(new Language(4, "C++"));
		languages.add(new Language(5, "C"));
		languages.add(new Language(6, "JavaScript"));
	}

	@Override
	public List<Language> getAll() {
		return languages;
	}

	@Override
	public Language getById(int id) {
		for (Language programmingLanguage : languages) {
			if (programmingLanguage.getId() == id) {
				return programmingLanguage;
			}
		}
		return null;
	}

	@Override
	public void add(Language language) {
		languages.add(language);
	}

	@Override
	public void update(Language language) {
		Language programmingLanguage = getById(language.getId());
		programmingLanguage.setName(language.getName());
	}

	@Override
	public void delete(int id) {
		languages.remove(id);
	}
}
