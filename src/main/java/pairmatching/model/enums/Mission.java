package pairmatching.model.enums;

public enum Mission {
    CAR_RACING(Level.LEVEL1, "자동차경주"),
    LOTTERY(Level.LEVEL1, "로또"),
    BASEBALL_GAME(Level.LEVEL1, "숫자야구게임"),
    SHOPPING_CART(Level.LEVEL2, "장바구니"),
    PAYMENT(Level.LEVEL2, "결제"),
    SUBWAY_MAP(Level.LEVEL2, "지하철노선도"),
    PERFORMANCE_IMPROVEMENT(Level.LEVEL4, "성능개선"),
    DEPLOYMENT(Level.LEVEL4, "배포");

    private final Level level;
    private final String name;

    Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }
}
