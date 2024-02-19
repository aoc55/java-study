package lecture.reflection.sample;

/**
 * (설명)
 * Created by aoc55.soft@gmail.com
 */
public class Movie extends Product{

    public static final String COUNTRY = "KOREA";

    private boolean isReleased;
    private Category category;
    private double actualPrice;

    public Movie(String name, int year, boolean isReleased, Category category, double actualPrice) {
        super(name, year);
        this.isReleased = isReleased;
        this.category = category;
        this.actualPrice = actualPrice;
    }

    public class MovieStats { // Nested Class
        private double timesWatched;

        public MovieStats(double timesWatched) {
            this.timesWatched = timesWatched;
        }

        public double getRevenue() {
            return this.timesWatched * actualPrice; // 외부 필드 접근
        }
    }
}
