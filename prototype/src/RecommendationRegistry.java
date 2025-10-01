import java.util.ArrayList;

public class RecommendationRegistry {
    private ArrayList<Recommendation> recommendations;

    public RecommendationRegistry() {
        this.recommendations = new ArrayList<>();
    }

    public void addRecommendation(Recommendation recommendation) {
        recommendations.add(recommendation);
    }

    public ArrayList<Recommendation> getAllRecommendations() {
        return recommendations;
    }

    @Override
    public String toString() {
        return "RecommendationRegistry{" +
                "recommendations=" + recommendations +
                '}';
    }
}
