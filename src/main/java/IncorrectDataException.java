public class IncorrectDataException extends RuntimeException  {

        public IncorrectDataException(String massage) {
            super("Данные не верны: " + massage);
        }
}
