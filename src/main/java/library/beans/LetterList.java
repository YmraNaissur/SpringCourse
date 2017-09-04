package library.beans;

import java.util.Arrays;
import java.util.List;

/**
 * naissur
 * 04.09.2017
 */
public class LetterList {
    /**
     * Метод возвращает список русских букв, по которым можно будет искать названия.
     * Он не содержит букв Ъ, Ь, Ы, т.к. названия не могут начинаться с этих букв
     * @return Список русских букв без Ъ, Ь, Ы
     */
    public List<Character> getRussianLetters() {
        Character[] lettersArray = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л',
                'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Э', 'Ю', 'Я'};
        return Arrays.asList(lettersArray);
    }
}