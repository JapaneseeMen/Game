public class NoRegisteredException extends RuntimeException {
    public NoRegisteredException(String massage) {
        super("Игрок не зарегистрирован : " + massage);
    }
}
