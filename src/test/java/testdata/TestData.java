package testdata;

import net.datafaker.Faker;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class TestData {

    private Faker fakerRu = new Faker(new Locale("ru"));
    private Faker fakerEng = new Faker();

    public static final String TEST_LOGIN = "avito9195@gmail.com";
    public static final String TEST_PASSWORD = "hoqqyn-weSjat-5zaqso1";

    private final List<String> patronymics = List.of(
            "Александрович", "Алексеевич", "Андреевич",
            "Владимирович", "Дмитриевич", "Иванович",
            "Михайлович", "Сергеевич"
    );

    public String userPhoneNumber = "+7" + fakerRu.number().digits(10);
    public String userFirstName = fakerRu.name().firstName();
    public String userLastName = fakerRu.name().lastName();
    public String userSecondName = patronymics.get(ThreadLocalRandom.current()
                    .nextInt(patronymics.size()));
    public String userEmail = fakerEng.internet().emailAddress();
}
