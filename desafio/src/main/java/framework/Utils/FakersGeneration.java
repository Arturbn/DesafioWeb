package framework.Utils;

import java.util.Locale;

import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

public class FakersGeneration {

	private Faker faker;

	private String name;

	private String mail;

	private String pass;

	public FakersGeneration() {

		faker = new Faker(new Locale("pt-BR"));

	}

	public String getName() {

		name = faker.name().name();
		return name;

	}

	public String getEmail() {

		mail = faker.internet().emailAddress();
		return mail;

	}

	public String getPass() {

		pass = faker.internet().password();
		return pass;

	}

}
