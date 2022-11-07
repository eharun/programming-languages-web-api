package Kodlama.io.Devs.programmingLanguages.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.programmingLanguages.entities.concretes.Language;

public interface LanguageService {

	List<Language> getAll();
	Language getById(int id) throws Exception;
	
	void add(Language language) throws Exception;
	void update(Language language) throws Exception;
	void delete(int id) throws Exception;

}
